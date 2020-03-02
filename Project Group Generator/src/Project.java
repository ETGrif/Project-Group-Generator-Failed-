import java.util.ArrayList;

public class Project
	{

		protected String projectName;
		protected ArrayList<Group> groups;

		public Project(String projectName)
			{
				this.projectName = projectName;
				this.groups = new ArrayList<Group>();

			}

		public void addGroup(Group group)
			{
				groups.add(group);

			}

		protected String getProjectName()
			{
				return projectName;
			}

		protected void setProjectName(String projectName)
			{
				this.projectName = projectName;
			}

		protected ArrayList<Group> getGroups()
			{
				return groups;
			}

		protected void setGroups(ArrayList<Group> groups)
			{
				this.groups = groups;
			}

		public void print()
			{

				System.out.println("\"" + this.projectName + "\"\n");
				for (Group g : this.groups)
					{
						System.out.println("\"" + g.getGroupName() + "\": " + g.getAverageGrade());
						for (Student s : g.getGroup())
							{
								System.out.println(s.getName());
							}
						System.out.println();

					}

			}

	}
