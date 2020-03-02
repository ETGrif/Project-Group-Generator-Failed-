import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SetUp
	{
		static Scanner userString = new Scanner(System.in);
		static Scanner userInt = new Scanner(System.in);

		static Group sortGroup = new Group("temp");

		public static void load()
			{
				// load files\
				//load roster
				Roster.load();
				
				//load projects
				ArrayList<String> names = FileReadAndWrite.loadProjectNames();
//				int loaded = 0;
				for (String n : names)
					{
						
						FileReadAndWrite.loadProjectFile(n.toString());
//						loaded++;
					}
//				System.out.println("Loaded "+loaded+" files.");
				
				// TODO calculate encounters
				for(Project p: Runner.projects) {
					for(Group g: p.getGroups()) {
						
						//for each student in each group, add all other students 
						for(Student s: g.getGroup()) {
							s.addEncounters(g.getGroup());
							System.out.println(s.getName() + " T");
							
							
							
							
						}
						
						
						
						
					}
				}

			}

		public static void makeNewProject()
			{
				System.out.println("-=-=-=-=-=-");
				System.out.println("Create new Project.");

				String projectName = takeInput("Name of Project:");

				System.out.println("Number of Groups:");
				int groups = userInt.nextInt();

				// TODO grab the number of students
				int students = 16;

				// generate ABBA
				String abba = AbbaGen.genAbba(groups, students);

				// create the project object
				Project project = new Project(projectName);

				// create groups
				for (int i = 0; i < groups; i++)
					{
						String groupName = "Group " + abba.substring(i, i + 1);
						project.addGroup(new Group(groupName));

					}

				// make copy of roster
				ArrayList<Student> roster = new ArrayList<Student>();
				roster.addAll(Roster.roster);

				// pick
				while (roster.size() > 0)
					{

						// figure out which group
						String indexHelp = "ABCDEFGHIJ";
						String groupLetter = abba.substring(0, 1);
//						System.out.println("Test: "+groupLetter);
						int index = indexHelp.indexOf(groupLetter);
						Group g = project.getGroups().get(index);
						abba = abba.substring(1);

						// //find best pick based on group
						Student pick = roster.get(0);
						for (Student s : roster)
							{
								if ((countConflicts(g, s) <= countConflicts(g, pick))
										&& (s.getGrade() > pick.getGrade()))
									{
//										System.out.println("Test");
										pick = s;
									}

							}
						// //add to group
						g.addStudent(pick);
//						System.out.println(g.getGroupName() + " picked " + pick.getName());

						// //remove from roster
						roster.remove(pick);
					}

				// TODO sort each group

				// update average grade
				for (Group g : project.getGroups())
					{
						g.updateAverageGrade();
					}

				// display +
				project.print();

				// TODO confirm / edit

				// "Post"
				Runner.projects.add(project);
				
				// write file
				FileReadAndWrite.writeProjectFile(project);
				FileReadAndWrite.writeProjectNames();

				

			}

		public static String takeInput(String open)
			{
				String response = "";
				boolean taking = true;
				while (taking)
					{
						System.out.println("Name of Project:");
						response = userString.nextLine();
						System.out.println("Confirm: \"" + response + "\" [Y/N]?");
						String confirm = userString.nextLine();
						if (confirm.toLowerCase().equals("y"))
							taking = false;

					}
				return response;
			}

		public static int countConflicts(Group g, Student s)
			{
				int total = 0;
				for (Student b : g.getGroup())
					{
						if (s.getEncountered().contains(b))
							{

								total++;
							}
					}
				System.out.println(s.getName() + ":" + total);
				return total;

			}

	}
