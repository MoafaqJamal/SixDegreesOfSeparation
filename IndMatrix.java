import java.io.*;
import java.util.*;


/**
 * Incidence matrix implementation for the FriendshipGraph interface.
 * 
 * Your task is to complete the implementation of this class.  You may add methods, but ensure your modified class compiles and runs.
 *
 * @author Jeffrey Chan, 2016.
 */
public class IndMatrix <T extends Object> implements FriendshipGraph<T>
{

    private ArrayList<T> Vs;
	private ArrayList<E> Es;
	private int[][] ind;
	int edgeIndex = 1;
	private int disconnectedDist = -1;
	private int col = 0;
	E anEdge = new E();
	
	/**
	 * Contructs empty graph.
	 */
    public IndMatrix() {
    	// Implement me!
    	Vs = new ArrayList<T>();
    	Es = new ArrayList<E>();
        ind = new int[10][10];
		
    } // end of IndMatrix()
    
    
    public void addVertex(T vertLabel) {
        // Implement me!
    	Vs.add(vertLabel);
    } // end of addVertex()
	
    
    public void addEdge(T srcLabel, T tarLabel) {
        // Implement me!  
        	anEdge.setSrcLabel(srcLabel);
        	anEdge.setTarLabel(tarLabel);
            Es.add(anEdge);

            ind[Vs.indexOf(srcLabel)][Es.indexOf(anEdge)] = 1;
            ind[Vs.indexOf(tarLabel)][Es.indexOf(anEdge)] = 1;        
        
    } // end of addEdge()
	

    public ArrayList<T> neighbours(T vertLabel) {
        ArrayList<T> neighbours = new ArrayList<T>();
        
        // Implement me!
        
        return neighbours;
    } // end of neighbours()
    
    
    public void removeVertex(T vertLabel) {
        // Implement me!
        Vs.set(Vs.indexOf(vertLabel), null);
    } // end of removeVertex()
	
    
    public void removeEdge(T srcLabel, T tarLabel) {
        // Implement me!
        ind[Vs.indexOf(srcLabel)][Es.indexOf(anEdge)] = 0;
        ind[Vs.indexOf(tarLabel)][Es.indexOf(anEdge)] = 0; 
    } // end of removeEdges()
	
    
    public void printVertices(PrintWriter os) {
        // Implement me!
        for (T v : Vs){
            if (v != null){
                os.print(v + " ");
            }
        }
        os.println();
    } // end of printVertices()
	
    
    public void printEdges(PrintWriter os) {
        // Implement me!
    	for (E e : Es){
               os.println(e);
        }
    	
    } // end of printEdges()
    
    
    public int shortestPathDistance(T vertLabel1, T vertLabel2) {
    	// Implement me!
    	
        // if we reach this point, source and target are disconnected
        return disconnectedDist;    	
    } // end of shortestPathDistance()
    
    //Edge object
    public class E {
    	private T srcLabel;
    	private T tarLabel;
    	public E () {
    	}
    	public E (T srcLabel, T tarLabel) {
    		this.srcLabel = srcLabel;
    		this.tarLabel = tarLabel;
    	}
    	public T getSrcLabel() {
    		return srcLabel;
    	}
    	public T getTarLabel() {
    		return tarLabel;
    	}
    	public void setSrcLabel(T srcLabel) {
    		this.srcLabel = srcLabel;
    	}
    	public void setTarLabel(T tarLabel) {
    		this.tarLabel = tarLabel;
    	}
    	public String toString() {
    		return getSrcLabel() + " " + getTarLabel() + "\n" + getTarLabel() + " " + getSrcLabel();
    	}
    }
} // end of class IndMatrix