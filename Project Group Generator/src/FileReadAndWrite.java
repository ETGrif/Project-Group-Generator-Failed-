import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReadAndWrite
	{

		private static Scanner file;

		public static void writeProjectFile(Project project)
			{

				String fileName = project.getProjectName() + ".txt";

				try
					{
						// Assume default encoding.
						FileWriter fileWriter = new FileWriter(fileName, false);

						// Always wrap FileWriter in BufferedWriter.
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

						// project name
						bufferedWriter.write(project.getProjectName());
						bufferedWriter.newLine();

						// group
						for (Group g : project.getGroups())
							{
								bufferedWriter.newLine();

								bufferedWriter.write(g.getGroupName());
								bufferedWriter.newLine();

								for (Student s : g.getGroup())
									{
										bufferedWriter.write(s.getName());
										bufferedWriter.newLine();

									}

							}

						// Always close files.
						bufferedWriter.close();
					}

				catch (IOException ex)
					{
						System.out.println("Error writing to file '" + fileName + "'");
						// Or we could just do this:
						// ex.printStackTrace();
					}

			}

		public static void loadProjectFile(String projectName)
			{

				File f = new File(projectName + ".txt");
				try
					{
						Scanner file = new Scanner(f);

						// pass the project name
						file.nextLine();
						file.nextLine();
						Project project = new Project(projectName);

						int subIndex = 0;
						Group group = null;

						while (file.hasNextLine())
							{
								String line = file.nextLine();
//								System.out.println(subIndex + ":" + line);

								if (subIndex == 0)
									{
										// group name
										group = new Group(line);
									} else if (subIndex > 0 && !line.equals(""))
									{
										// students
										group.addStudent(Roster.findStudentByName(line));
									} else
									{
										// create the actual group
										group.updateAverageGrade();
										project.addGroup(group);
										subIndex = -1;
									}
								subIndex++;

							}
						//code misses the last group, so this catches it
						group.updateAverageGrade();
						project.addGroup(group);
						
						Runner.projects.add(project);

					} catch (FileNotFoundException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}

		public static void writeProjectNames()
			{

				String fileName = "ProjectNames.txt";

				try
					{
						// Assume default encoding.
						FileWriter fileWriter = new FileWriter(fileName, false);

						// Always wrap FileWriter in BufferedWriter.
						BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
						
						
//						System.out.println("Writing "+Runner.projects.size()+" names in file.");
						for (Project p : Runner.projects)
							{
								bufferedWriter.write(p.getProjectName());
								bufferedWriter.newLine();
							}

						// Always close files.
						bufferedWriter.close();
					}

				catch (IOException ex)
					{
						System.out.println("Error writing to file '" + fileName + "'");
						// Or we could just do this:
						// ex.printStackTrace();
					}

			}

		public static ArrayList<String> loadProjectNames()
			{

				File f = new File("ProjectNames.txt");
				ArrayList<String> names = new ArrayList<String>();

				try
					{
						file = new Scanner(f);

						while (file.hasNextLine())
							{
								String name = file.nextLine();
								if(!name.equals("")) {
									names.add(name);

								}
							}

					} catch (FileNotFoundException e)
					{
						// Auto-generated catch block
						e.printStackTrace();
					}
				return names;

			}
	}
