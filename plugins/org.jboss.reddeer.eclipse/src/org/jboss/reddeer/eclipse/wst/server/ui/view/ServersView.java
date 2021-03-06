package org.jboss.reddeer.eclipse.wst.server.ui.view;

import java.util.ArrayList;
import java.util.List;

import org.jboss.reddeer.common.logging.Logger;
import org.jboss.reddeer.common.logging.LoggingUtils;
import org.jboss.reddeer.core.exception.CoreLayerException;
import org.jboss.reddeer.eclipse.exception.EclipseLayerException;
import org.jboss.reddeer.eclipse.wst.server.ui.wizard.NewServerWizardDialog;
import org.jboss.reddeer.swt.api.Tree;
import org.jboss.reddeer.swt.api.TreeItem;
import org.jboss.reddeer.swt.impl.menu.ContextMenu;
import org.jboss.reddeer.swt.impl.shell.DefaultShell;
import org.jboss.reddeer.swt.impl.tree.DefaultTree;
import org.jboss.reddeer.workbench.impl.view.WorkbenchView;

/**
 * Represents the Servers view. This class contains methods that can be invoked even 
 * if no server is selected. You can invoke server specific operations on {@link Server} instances. 
 * 
 * @author Lucia Jelinkova
 *
 */
public class ServersView extends WorkbenchView {

	public static final String TITLE = "Servers";

	private static final Logger log = Logger.getLogger(ServersView.class);

	/**
	 * Constructs the view with {@value #TITLE}.
	 */
	public ServersView() {
		super(TITLE);
	}

	/**
	 * Opens a wizard for adding new server.
	 * 
	 * @return Wizard for adding new server
	 */
	public NewServerWizardDialog newServer(){
		activate();
		log.info("Create new server");
		new ContextMenu("New","Server").select();
		new DefaultShell("New Server");
		return new NewServerWizardDialog();
	}

	/**
	 * Returns list of servers.
	 * 
	 * @return List of servers
	 */
	public List<Server> getServers(){
		List<Server> servers = new ArrayList<Server>();

		Tree tree;
		try {
			tree = getServersTree();
		} catch (CoreLayerException e){
			return new ArrayList<Server>();
		}
		for (TreeItem item : tree.getItems()){
			if (item != null && !item.isDisposed()){
				servers.add(createServer(item));	
			}			
		}
		return servers;
	}

	/**
	 * Returns a server with a given name.
	 * 
	 * @param name Server name
	 * @return Server with a given name.
	 */
	public Server getServer(String name){
		for (Server server : getServers()){
			if (server.isValid() && server.getLabel().getName().equals(name)){
				return server;
			}
		}
		log.info("Requested server '" + name + "' was not found on Servers view");
		log.info("Available servers are: " + LoggingUtils.format(getServersNames()));
		throw new EclipseLayerException("There is no server with name " + name);
	}

	/**
	 * Gets the servers tree.
	 *
	 * @return the servers tree
	 */
	protected Tree getServersTree(){
		activate();
		return new DefaultTree();
	}

	/**
	 * Creates the server.
	 *
	 * @param item the item
	 * @return the server
	 */
	protected Server createServer(TreeItem item){
		return new Server(item, this);
	}
	
	private Object[] getServersNames() {
		List<Server> servers = getServers();
		Object[] names = new Object[servers.size()];
		
		for (int i = 0; i < servers.size(); i++){
			names[i] = servers.get(i).getLabel().getName();
		}
		
		return names;
	}
}
