import java.util.ArrayList;

public class Runner
	{

		static ArrayList<Project> projects = new ArrayList<Project>();
		
		public static void main(String[] args)
			{
				
				SetUp.load();
				FileReadAndWrite.writeProjectNames();
//				System.out.println("Menu: \n"
//						+ "1) View Roster\n"
//						+ "2) View Current Projects\n"
//						+ "3) Create New Project");
				
				SetUp.makeNewProject();
				
				
			}
		
		
		
	}
