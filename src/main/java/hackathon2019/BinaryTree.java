package hackathon2019;

public class BinaryTree 
{
	private String word;
	private String link;
	private BinaryTree left;
	private BinaryTree right;

	public BinaryTree(String string, String website) 
	{
		this.word = string;
		this.link = website;
		this.left = null;
		this.right = null;
	}

	public void addNode(String string, String website) 
	{
		if (string.compareToIgnoreCase(this.word) < 0) 
		{
			if (this.left != null) 
			{
				this.left.addNode(string, website);
			} 
			else 
			{
				this.left = new BinaryTree(string, website);
			}

		} 
		else 
		{
			if (this.right != null) 
			{
				this.right.addNode(string, website);
			}
			else 
			{
				this.right = new BinaryTree(string, website);
			}

		}
	}

	public String search(String word) 
	{
		if (word.compareToIgnoreCase(this.word) == 0)
		{
			return this.link;
		}
		else if (word.compareToIgnoreCase(this.word) < 0) 
		{
			if (left == null)
			{
				return null;
			}
			else
			{
				return left.search(word);
			}
		}
		else if (word.compareToIgnoreCase(this.word) > 0) 
		{
			if (right == null)
			{
				return null;
			}
			else
			{
				return right.search(word);
			}
		}
		return null;
	}
}


