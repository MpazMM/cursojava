package ddbb;

public class Facilities {

	private long id;
	private int guid;
	private String name;
	private String description;
	private String category;
	private String adress;
	private double heigth;


	/**
	 * @param id
	 * @param guid
	 * @param name
	 * @param description
	 * @param category
	 */
	public Facilities(long id, int guid, String name, String description, String category) {
		super();
		this.id = id;
		this.guid = guid;
		this.name = name;
		this.description = description;
		this.category = category;
	}


	/**
	 * @param id
	 * @param guid
	 * @param name
	 * @param description
	 * @param category
	 * @param adress
	 * @param heigth
	 */
	public Facilities(long id, int guid, String name, String description, String category, String adress,
			double heigth) {
		super();
		this.id = id;
		this.guid = guid;
		this.name = name;
		this.description = description;
		this.category = category;
		this.adress = adress;
		this.heigth = heigth;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public int getGuid() {
		return guid;
	}


	public void setGuid(int guid) {
		this.guid = guid;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public double getHeigth() {
		return heigth;
	}


	public void setHeigth(double heigth) {
		this.heigth = heigth;
	}


	
}
