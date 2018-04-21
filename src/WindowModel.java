import java.util.ArrayList;
import java.util.List;


public class WindowModel {

	
	private List <String> windowElements;
	private List <WindowView> childWindowsList;
	
	
	public WindowModel(WindowController windowController) {
		
        this.windowElements = new ArrayList<>();
        this.childWindowsList = new ArrayList<>();
        
    }
	
		
	public void addData(String data) {
		
		this.windowElements.add(data);
		
	}
	
	
	public void addWindowToList (WindowView data) {
		
		this.childWindowsList.add(data);
		
	}
	
	
	public String getJoinedData() {
		
		StringBuilder joinedData = new StringBuilder();
		for (String i : windowElements) {
			joinedData.append(i);
			if (!i.equals("")) {							
				joinedData.append('\n');
			} 
		}
		
		return joinedData.toString();
	
    }
	
	
	public WindowView getWindow (int i) {
		
		return childWindowsList.get(i);
		
	}
	
	
	public int getChildWindowsListSize() {
		
		return childWindowsList.size();
		
	}
	
}
