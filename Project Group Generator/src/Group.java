import java.util.ArrayList;

public class Group
	{

		protected String groupName;
		protected ArrayList<Student> group;
		protected double averageGrade;

		public Group(String groupName)
			{
				this.groupName = groupName;
				this.group = new ArrayList<Student>();
				this.averageGrade = 0.0;
			}

		public String getGroupName()
			{
				return groupName;
			}

		public void setGroupName(String groupName)
			{
				this.groupName = groupName;
			}

		public ArrayList<Student> getGroup()
			{
				return group;
			}

		public void setGroup(ArrayList<Student> group)
			{
				this.group = group;
			}

		public double getAverageGrade()
			{
				return averageGrade;
			}

		public void setAverageGrade(double averageGrade)
			{
				this.averageGrade = averageGrade;
			}

		public void addStudent(Student student)
			{
				this.group.add(student);
			}

		public void updateAverageGrade()
			{
				double total = 0.00;
				for (Student s : group)
					{
						total += s.getGrade();
					}
				total /= group.size();
				total = ((int) (total * 100)) / 100.00;
				this.averageGrade = total;

			}

	}
