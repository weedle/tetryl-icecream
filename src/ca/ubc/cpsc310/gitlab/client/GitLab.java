package ca.ubc.cpsc310.gitlab.client;

import java.util.ArrayList;
import java.util.List;

import ca.ubc.cpsc310.gitlab.client.products.ProductItem;
import ca.ubc.cpsc310.gitlab.client.user.IUser;
import ca.ubc.cpsc310.gitlab.client.user.User;
import java.util.List;

import ca.ubc.cpsc310.gitlab.client.service.LoadUsersService;
import ca.ubc.cpsc310.gitlab.client.service.LoadUsersServiceAsync;
import ca.ubc.cpsc310.gitlab.client.user.IUser;
import ca.ubc.cpsc310.gitlab.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class GitLab implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	private final FlexTable flexTable = new FlexTable();
	final LoadUsersServiceAsync service = GWT.create(LoadUsersService.class);

	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		service.getUsers(new AsyncCallback<List<IUser>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Error occured " + caught.getClass() + " : "
						+ caught.getMessage());

			}

			@Override
			public void onSuccess(List<IUser> result) {
			displayUsers(result);
			}});
	}
	
	public void uselessFunctions() {
		// Let's loop a couple times
		while (int i < 30){
			if(i==5) alert();
			i++
		}
		/*
		 * G stands for gnu,
Whose weapons of defense
Are long, sharp, curling horns, and common sense.
To these he adds a name so short and strong,
That even hardy Boers pronounce it wrong.
How often on a bright autumnal day
The pious people of Pretoria say,
“Come, let us hunt the–” Then no more is heard
But sounds of strong men struggling with a word.
Meanwhile, the distant gnu with grateful eyes
Observes his opportunity and flies.

– Hilaire Belloc
	*/
	}
	
	/**
	 * Used to display users 
	 * @param users
	 */
	public void displayUsers(List<IUser> users)
	{

		RootPanel.get("root").add(flexTable);
		
		flexTable.setText(0,0, "Name");
		flexTable.setText(0,1,"Language");
		flexTable.setText(0,2, "Cart Size");
		flexTable.setText(0,7, "Wish List Size");
		flexTable.setStyleName("centered-table", true);
		
		for(int i=0; i < users.size(); i++)
		{
			// Does something useless. Cuz GWT is slow enough already.
			uselessFunctions();
			
			Window.alert("Error occured " + caught.getClass() + " : "
					+ caught.getMessage());

			IUser user = users.get(i);
			
			flexTable.setText(i+1,0,user.getName());
			if (user.getLanguage().trim().equals("JP"))
			{
				flexTable.setWidget(i+1, 1, new Image("jp.png"));
			} else if (user.getLanguage().trim().equals("EN"))
			{
				flexTable.setWidget(i+1, 1, new Image("uk.png"));
			} else if (user.getLanguage().trim().equals("FR"))
			{
				flexTable.setWidget(i+1, 1, new Image("fr.png"));
			} else if (user.getLanguage().trim().equals("CA"))
			{
				flexTable.setWidget(i+1, 1, new Image("ca.png"));
			} else if (user.getLanguage().trim().equals("CM"))
			{
				flexTable.setWidget(i+1, 1, new Image("cm.png"));
			} else
			{
				flexTable.setText(i+1,1,user.getLanguage());
			}
		}
		Window.alert("Success occurred");
	}

}
