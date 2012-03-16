package common.util.ssh;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;

import com.sshtools.j2ssh.SshClient;
import com.sshtools.j2ssh.authentication.AuthenticationProtocolState;
import com.sshtools.j2ssh.authentication.PasswordAuthenticationClient;
import com.sshtools.j2ssh.authentication.PublicKeyAuthenticationClient;
import com.sshtools.j2ssh.authentication.SshAuthenticationClient;
import com.sshtools.j2ssh.connection.ChannelState;
import com.sshtools.j2ssh.session.SessionChannelClient;
import com.sshtools.j2ssh.transport.IgnoreHostKeyVerification;
import com.sshtools.j2ssh.transport.publickey.SshPrivateKeyFile;
import com.sshtools.j2ssh.util.InvalidStateException;

public class SshShell {
    private String host;
	private SshClient sshClient;
	private SessionChannelClient session;
	private SshAuthenticationClient authClient;

	public SshShell(String host, String user, String password) throws Exception {
        this.host = host;
		sshClient = new SshClient();
		
		PasswordAuthenticationClient auth = new PasswordAuthenticationClient();
		auth.setUsername(user);
		auth.setPassword(password);
		authClient = auth;
	}

	public SshShell(String host, String keyFile) throws Exception {
	    this.host = host;
        sshClient = new SshClient();
        
		SshPrivateKeyFile file = SshPrivateKeyFile.parse(new File(keyFile));
		PublicKeyAuthenticationClient auth = new PublicKeyAuthenticationClient();
		auth.setKey(file.toPrivateKey(null));
		authClient = auth;
	}

	public void open() throws Exception {
        sshClient.connect(host, new IgnoreHostKeyVerification());
		int result = sshClient.authenticate(authClient);
		if ((result == AuthenticationProtocolState.FAILED) || (result == AuthenticationProtocolState.PARTIAL)) {
			throw new Exception("authentication failed");
		}
		session = sshClient.openSessionChannel();
		session.startShell();
	}

	public void close() throws Exception {
		session.close();
		sshClient.disconnect();
	}

	public InputStream run(String cmd) throws Exception {
		OutputStream out = session.getOutputStream();
		out.write(cmd.getBytes());
		out.close();

		InputStream in = session.getInputStream();
		return in;
	}

	/**
	 * Call this after the session has been closed to obtain the exit code of the process
	 * @return the exit code of the process once complete.
	 * @throws Exception 
	 * @throws InvalidStateException 
	 */
	public Integer getExitCode() throws Exception {
        session.getState().waitForState(ChannelState.CHANNEL_CLOSED);
		return session.getExitCode();
	}
	
	public InputStream getStderrInputStream() throws IOException {
	    return session.getStderrInputStream();
	}
	
	public OutputStream getOutputStream() {
	    return session.getOutputStream();
	}

	public boolean isClosed() {
		return session.isClosed();
	}

	public static void main(String args[]) throws Exception {
		SshShell shell = new SshShell("192.168.2.50", "root", "r3dmine!");
		shell.open();
		InputStream is = shell.run("ls\n");
		String output = IOUtils.toString(is);
		System.out.println(output);
		System.out.println("exit code: " + shell.getExitCode());
		shell.close();
	}

    public InputStream getInputStream() {
        return session.getInputStream();
    }
}
