import java.util.ArrayList;

public class Student
	{

		protected String name;
		protected double grade;
		protected ArrayList<Student> encountered;

		public Student(String name, double grade)
			{
				this.name = name;
				this.grade = grade;
				this.encountered = new ArrayList<Student>();

			}

		public String getName()
			{
				return name;
			}

		public void setName(String name)
			{
				this.name = name;
			}

		public double getGrade()
			{
				return grade;
			}

		public void setGrade(double grade)
			{
				this.grade = grade;
			}

		public ArrayList<Student> getEncountered()
			{
				return encountered;
			}

		public void addEncounters(ArrayList<Student> group)
			{
				this.encountered.addAll(group);
			}

	}
