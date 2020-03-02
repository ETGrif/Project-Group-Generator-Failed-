import java.util.ArrayList;

public class AbbaGen
	{

		public static String genAbba(int groups, int students)
			{

				String base = "";
				for (int i = 0; i < groups; i++)
					{
						base += "" + i;
					}
//				System.out.println("B: " + base);

				while (base.length() <= students)
					{
						String sequence = "";
						for (int i = 0; i < groups; i++)
							{
								base = shift(base, groups);
								sequence += base;

							}
						base = sequence;
//						System.out.println("U: " + base);
					}

				base = base.substring(0, students);
				return numToLetters(base);

			}

		public static String shift(String s, int groups)
			{
				String result = "";
				String[] letters = s.split("");
				for (int i = 0; i < letters.length; i++)
					{
						int num = Integer.parseInt(letters[i]);
						num = (num + 1) % groups;
						result += "" + num;
					}
				return result;

			}

		public static String numToLetters(String str)
			{

				String[] s = str.split("");
				String result = "";
				String[] letters = { "A", "B", "C", "D", "E", "F", "G", "H", "I" };
				ArrayList<String> indexes = new ArrayList<String>();
				for (String n : s)
					{
						if (!indexes.contains(n))
							{
								indexes.add(n);
							}
						result += letters[indexes.indexOf(n)];
					}
				return result;

			}

	}
