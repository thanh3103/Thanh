package entities;

public class Danhmuc {
	private int madm;
	private String tendm;
	private int deleted;

	public int getDeleted() {
		return deleted;
	}

	public void setDeleted(int deleted) {
		this.deleted = deleted;
	}

	public Danhmuc(int madm, String tendm, int deleted) {
		super();
		this.madm = madm;
		this.tendm = tendm;
		this.deleted = deleted;
	}

	public Danhmuc() {

	}

	public Danhmuc(int madm, String tendm) {
		this.madm = madm;
		this.tendm = tendm;
	}

	public int getMadm() {
		return madm;
	}

	public void setMadm(int madm) {
		this.madm = madm;
	}

	public String getTendm() {
		return tendm;
	}

	public void setTendm(String tendm) {
		this.tendm = tendm;
	}

}
