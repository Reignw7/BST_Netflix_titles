import java.io.*;

public class BinarySearchTree extends BinaryNode {
    private static BinaryNode root;

    BinarySearchTree(){
        root = null;
    }

    BinarySearchTree(String x){
        root = new BinaryNode(null, x,-1);
    }
    BinarySearchTree(String x , String y){
        root = new BinaryNode(x, y,-1);
    }

    static void insert(String theType, String theTitle, int theReleaseYear){
        BinaryNode x = new BinaryNode(theType, theTitle, theReleaseYear);
        BinaryNode tempNode = root;

        if(root != null){

            //While loop that find the nearest appropriate leaf in the BST
            while(true){
                //checking if the current node is less than the node to be inserted
                if(tempNode.getTitle().compareTo(x.getTitle())<=0){
                    //Checking if the right node is null
                    if(tempNode.getRight() ==null){
                        tempNode.setRight(x); //inserting the node
                        break;
                    }
                    tempNode = tempNode.getRight();
                    //tempNode.getTitle().compareTo(x.getTitle())>0
                }else{
                    if(tempNode.getLeft() == null){
                        tempNode.setLeft(x);
                        break;
                    }else{
                        tempNode = tempNode.getLeft();
                    }
                }
            }
        }else{
            root = x;
            return;
        }
    }

    static void remove(String theTitle){

        //creating a temporary node to traverse BST
        BinaryNode tempNode = root;
        BinaryNode removeNode = find(theTitle);

        if(tempNode != null){
            if(removeNode.getTitle() == theTitle){
                if(removeNode.getRight()==null && removeNode.getLeft()== null){
                    removeNode=null;
                }
            }
        }

    }


    static BinaryNode find(String theTitle){
        //creating a temporary node to traverse BST
        BinaryNode tempNode = root;

        if(root==null){
            return null;
        }

        if(root != null){
            //traversing through BST to find a match
            while(true) {
                if(tempNode.getTitle().compareTo(theTitle)<0){
                    tempNode = tempNode.getRight();
                    //if the new node to be checked is null then break
                    if(tempNode == null){
                        System.out.println("There is no such title in the library");
                        return null;
                    }
                }else if(tempNode.getTitle().compareTo(theTitle)>0){
                    tempNode = tempNode.getLeft();
                    //if the new node to be checked is null then break
                    if(tempNode == null){
                        System.out.println("There is no such title in the library");
                        return null;
                    }
                }else{
                    System.out.println("The " + tempNode.getType() + " " + tempNode.getTitle() + " was released " + tempNode.getReleaseYear());
                    return tempNode; //returns the node that has the match
                }
            }
        }

        System.out.println("There is no such title in the library");
        return null; //Match not found
    }

    static void printInOrder(BinaryNode x){

        if(x.getLeft() !=null){
            printInOrder(x.getLeft()); //recursion to get result
        }

        System.out.println(x.getTitle());

        if(x.getRight() != null){
            printInOrder(x.getRight());//recursion to get result
        }
    }

    static int counter(BinaryNode x, int year){
        int Counter= 0;
        if(x.getLeft() !=null){
            if (x.getReleaseYear() == year){
                Counter++;
            }
            counter(x.getLeft(), year); //recursion to get result
        }

        if(x.getRight() != null){
            if (x.getReleaseYear() == year){
                Counter++;
            }
            counter(x.getRight(), year);//recursion to get result
        }

        return Counter;
    }

    static String toString(BinaryNode a){

        System.out.println(a.getTitle() +" | "+ a.getType() +" | "+ a.getReleaseYear());

        if(a.getLeft() !=null){
            toString(a.getLeft()); //recursion to get result
        }
        if(a.getRight() != null){
            toString(a.getRight());//recursion to get result
        }
        return null;
    }

    public static void main(String[] args){

        BinarySearchTree BST = new BinarySearchTree();

        try{
            BufferedReader br = new BufferedReader(new FileReader("netflix_titles.csv"));
            String line = "";
            while((line =br.readLine()) != null){
                //preparing data to be read from the csv file
                String[] data = line.split(",");
                String Type =  data[1];
                String Title = data[2];
                String Release_year = data[7];

                //creates Binary nodes and inserts into a tree
                BST.insert(Type, Title, -1);
            }

            br.close();
        }catch(Exception e){

        }


        //Test for toString method
        //toString(BST.root);

        //Testing to see if certain titles are in the netflix library
        //Mudbound
        find("Mudbound");
        //Let’s Dance 2
        find("Let’s Dance 2");
        //Yankee
        find("Yankee");

        //Displaying in-order traversal of the BST
        printInOrder(BST.root);

        System.out.println(counter(BST.root, 2021));
        System.out.println(root.getLeft().getTitle());


    }


}
