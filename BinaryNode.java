public class BinaryNode {
    // Data
    private String type; // movie or tv show
    private String title; // title of movie/tv show
    private int releaseYear; // release year of movie/tv show
    private BinaryNode left; // left child
    private BinaryNode right; // right child

    public BinaryNode(){

    }

    public BinaryNode (String Type, String Title, int Release_year){
        this.type = Type;
        this.title = Title;
        this.releaseYear = Release_year;
        this.left = null;
        this.right = null;
    }

    //accessor methods
    
    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getType() {
        return type;
    }

    public BinaryNode getLeft() {
        return left;
    }

    public BinaryNode getRight() {
        return right;
    }

    //mutator methods

    public void setLeft(BinaryNode left) {
        this.left = left;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public void setRight(BinaryNode right) {
        this.right = right;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setType(String type) {
        this.type = type;
    }
}


