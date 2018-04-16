
public class Joueur {
	private int PlayerId; /** Jcrois que c'est pas n�cessaire mais ca me fait bizarre de pas en avoir */
	private int abs;
	private int ord;
	private int ActionsPerfomed = 0;
	private final int MaxActions = 3;
	
	Joueur(int abs,int ord,int Id){
		this.abs=abs;
		this.ord=ord;
		this.PlayerId=Id;
	}
/** Deplacements */
	public void moveLeft() {
		this.abs = this.abs-1;
	}	
	public void moveRight() {
		this.abs = this.abs+1;
	}	
	public void moveUp() {
		this.ord = this.ord-1;
	}	
	public void moveDown() {
		this.ord = this.ord+1;
	}
/** Nombre Actions */
	public void oneAction() {
		this.ActionsPerfomed+=1;
	}
	public boolean canAct() {
		return this.ActionsPerfomed!=MaxActions;
	}
	public void resetActions() {
		this.ActionsPerfomed=0;
	}
	public int ActionsLeft() {
		return this.MaxActions - this.ActionsPerfomed;
	}
/** Getters */	
	public int getAbs(){
		return this.abs;
	}
	public int getOrd() {
		return this.ord;
	}
	public int getId() {
		return this.PlayerId;
	}
	
}
