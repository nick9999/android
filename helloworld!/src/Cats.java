public class Cats extends Animal
	{
		public String favToy="Toy";
		public void playWith()
		{
			System.out.println(favToy);
		}
		public void walkAround()
		{
			System.out.println(this.getName()+"stalks Around");
		}
		public String getToy()
		{
			return this.favToy;
		}
		public Cats()
		{
			
		}
		public Cats(String name,String favFood,String favToy)
		{
			super(name,favFood);
			this.favToy=favToy;
		}
		
	}
