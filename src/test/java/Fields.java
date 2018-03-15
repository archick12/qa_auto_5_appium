import org.openqa.selenium.By;

public class Fields {
  final static String user = "br777roman@gmail.com";
  final static String password = "1478965roman";
  final static String goal_contact_name = "Arthur Pilyuk";
  final static String message_to_user = "Hi, Artur! It is my third steps with mobile testing!";

  final static String app_package_name = "com.linkedin.android:id/";
  final static By firstSignIn = By.id(app_package_name + "growth_prereg_fragment_sign_in_button");
  final static By userEmail = By.id(app_package_name + "growth_login_join_fragment_email_address");
  final static By userPassword = By.id(app_package_name + "growth_login_join_fragment_password");
  final static By showButton = By.id(app_package_name + "growth_login_join_show_hide_password");
  final static By sign_inButton = By.id(app_package_name + "growth_login_fragment_sign_in");
  final static By feedButton = By.name("Feed, Tab 1 of 5");
  final static By myNetworkButton = By.name("My Network, Tab 2 of 5");
  final static By connectionsButton = By.id(app_package_name + "relationships_connection_home_button");
  final static By top_cardConnectionsButton = By.id(app_package_name + "relationships_top_card_connections_button");
  final static By connecionsTextInConnectionsMenu = By.name("Connections");
  final static By my_goal_contact = By.name(goal_contact_name);
  final static By profile_view_top_card_primary_Button = By.id(app_package_name + "profile_view_top_card_primary_button");
  final static By text_input_container_field = By.id(app_package_name + "msglib_keyboard_text_input_container");
  final static By keyboard_send_button = By.id(app_package_name + "msglib_keyboard_send_button");
  final static By icon_message_to_user = By.name(message_to_user);

}