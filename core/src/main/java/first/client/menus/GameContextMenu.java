package first.client.menus;

public interface GameContextMenu {
//this interface will be used for creating context menus
//this way the mouse doesn't have to handle logic for every possible different context menu
//instead, the mouse will just call the context menu's methods
public GameContextMenu getMenuOptions();




}
