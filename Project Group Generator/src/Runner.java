import java.util.ArrayList;
import java.util.Scanner;

public class Runner
	{
		static Scanner userInt = new Scanner(System.in);

		static ArrayList<Project> projects = new ArrayList<Project>();

		public static void main(String[] args)
			{
				while (true)
					{

						SetUp.load();
						System.out.println("Menu: \n" + "1) View Roster\n" + "2) View Current Projects\n"
								+ "3) Create New Project\n" + "4) Exit");

						int answer = takeInt(4);
//						System.out.println(answer);

						System.out.println("-=-=-=-=-=-");

						switch (answer)
							{
							case 1:
								printRoster();
								break;
							case 2:
								printProjects();
								break;
							case 3:
								SetUp.makeNewProject();
								break;
							case 4:
								System.exit(0);

							}

						System.out.println("\n-=-=-=-=-=-");
					}

			}

		private static void printRoster()
			{
				for(Student s: Roster.roster) {
					System.out.println(s.getName());
				}
				
			}

		private static void printProjects()
			{
				if (projects.size() == 0)
					{
						System.out.println("There are no current projects!");
						return;
					}

				int index = 1;
				for (Project p : projects)
					{
						System.out.println(index++ + ") " + p.getProjectName());
					}
				if (projects.size() > 1)
					{
						System.out.println(index + ") All");
					}

				index = takeInt(projects.size() + 1);

				if (index == projects.size() + 1)
					{
						for (Project p : projects)
							{
								p.print();
								System.out.println();
							}

					} else
					{
						projects.get(--index).print();
					}

			}

		public static int takeInt(int max)
			{

				System.out.print(":");

				while (true)
					{
						int answer = userInt.nextInt();
						if (answer > 0 && answer <= max)
							{
								return answer;
							} else
							{
								System.out.print(":");
							}

					}

			}

	}
