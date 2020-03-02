import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Roster
	{

		static ArrayList<Student> roster = new ArrayList<Student>();

		public static void load()
			{

				try
					{
						File fileName = new File("Roster.txt");
						Scanner file = new Scanner(fileName);

						while (file.hasNextLine())
							{

								String line = file.nextLine();
								String[] values = line.split(", ");
								String name = values[0];
								double grade = Double.parseDouble(values[1]);
								roster.add(new Student(name, grade));
//								System.out.println("Added "+name+" with a  %"+grade+".");

							}

					} catch (FileNotFoundException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

			}

		public static Student findStudentByName(String name)
			{

				for (Student s : roster)
					{
						if (s.getName().equals(name))
							{
								return s;
							}
					}
				return null;

			}

	}
