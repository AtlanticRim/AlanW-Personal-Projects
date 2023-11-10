/*---------------------------------------------------
 *  Author: J. Alan Wallace
 *  Written: 1/19/2023
 *  Last Updated: 1/21/2023
 *  
 *  Compilation: javac GraphOfCitiesTestCode.java
 *  Execution: java GraphOfCitiesTestCode
 *  
 *  Description:
 *  A program that implements a GraphOfCities class, which is a graph data structure
 *  for storing cities and their distances. The main method provides a test program.
 *  The following methods are implemented in the GraphOfCities class: addVertex, addEdge,
 *  deleteVertex, deleteEdge, printVertices, printEdges, getSize, getNeighbors, getDegree, isEmpty
 *  BFS, DFS, printAdjMatrix, toString, and equals.
 *  
 *  Sample Output:
 *  Vertices: 0 Edges: 0
 *  Vertices: 5 Edges: 10
 *  The neighbors of Columbia are: The requested vertex could not be found
 *  The neighbors of Columbia are: Florence, Charlotte, Charleston, Myrtle Beach, 
 *  The degree of Columbia is: The requested vertex could not be found
 *  The degree of Columbia is: 4
 *  The edges are: 
 *  Florence --> Columbia: 92 miles
 *  Florence --> Charlotte: 106 miles
 *  Columbia --> Charlotte: 80 miles
 *  Vertices: Florence, Columbia, Charlotte, 
 *  
 *  The edges are: 
 *  Florence --> Columbia: 92 miles
 *  Florence --> Charlotte: 106 miles
 *  Columbia --> Charlotte: 80 miles
 *  Florence --> Charleston: 136 miles
 *  Columbia --> Charleston: 120 miles
 *  Charlotte --> Charleston: 209 miles
 *  Florence --> Myrtle Beach: 67 miles
 *  Columbia --> Myrtle Beach: 152 miles
 *  Charlotte --> Myrtle Beach: 175 miles
 *  Charleston --> Myrtle Beach: 95 miles
 *  Vertices: Florence, Columbia, Charlotte, Charleston, Myrtle Beach, 
 *  
 *  The degree of B is: 2
 *  Breadth-First Traversal: A, B, C, D, E, F, 
 *  Depth-First Traversal: A, B, D, E, F, C, 
 *---------------------------------------------------*/

package homework;
import java.util.*;

public class GraphOfCitiesTestCode {
    public static void main(String args[]) 
    { 
  
        // This code was provided in the assignment
        GraphOfCities graph1 = new GraphOfCities(); 

        String[] cities = {"Florence", "Columbia", "Charlotte", "Charleston", "Myrtle Beach"};
        int[][] distances = 
        {
            {0, 92,106, 136, 67},
            {92, 0, 80, 120, 152},
            {106, 80, 0, 209, 175},
            {136, 120, 209, 0, 95},
            {67, 152, 175, 95, 0}
        };
        GraphOfCities graph2 = new GraphOfCities(cities, distances); 
  
        graph1.getSize();
        graph2.getSize();

        graph1.getNeighbors("Columbia");
        graph2.getNeighbors("Columbia");
  

        graph1.getDegree("Columbia");
        graph2.getDegree("Columbia");

        graph1.isEmpty();
        graph2.isEmpty();


        graph1.addVertex("Florence");
        graph1.addVertex("Columbia");
        graph1.addVertex("Charlotte");
        graph1.addEdge("Florence", "Columbia", 92);
        graph1.addEdge("Florence", "Charlotte", 106);
        graph1.addEdge("Columbia", "Charlotte", 80);


        graph1.printEdges();
        graph1.printVertices();

        graph2.printEdges();
        graph2.printVertices();

        graph1.deleteEdge("Columbia", "Charlotte");
        graph1.deleteEdge("Columbia", "Charlotte");


        graph2.deleteEdge("Columbia", "Charlotte");
        graph2.deleteEdge("Columbia", "Charlotte");
        
        // This test code was written by the author
        GraphOfCities g = new GraphOfCities();
        g.addVertex("A");
        g.addVertex("B");
        g.addEdge("A", "B", 1);

        g.addVertex("C");
        g.addEdge("A", "C", 500);
        
        g.addVertex("D");
        g.addEdge("B", "D", 21);
        
        g.addVertex("E");
        g.addEdge("D", "E", 31);
        
        g.addVertex("F");
        g.addEdge("D", "F", 32);
        
        g.getDegree("B");
        
        g.BFS();
        g.DFS();
        
    }   
} // end GraphOfCitiesTestCode class

class GraphOfCities{
    ArrayList<String> cities = null;
    int[][] am = null;
   
    
    public GraphOfCities() {
        // Default constructor that initializes this cities ArrayList and am matrix
        
        this.cities = new ArrayList<String>();
        this.am = new int[0][0];
    } // end default constructor
    
    public GraphOfCities(String[] cities, int[][] distance) {
        /* Constructor that takes in an array of vertices and an int matrix for weights.
         * By default, this assumes that all of the cities passed as arguments are
         * all connected to each other (i.e. the graph is complete).*/
        
        // Adds all cities to the cities ArrayList
        this.cities = new ArrayList<String>();
        for (String city: cities) {
            this.cities.add(city);
        }
        
        // Create all edges with the weights specified in the distance matrix
        this.am = new int[cities.length][cities.length];
        for (int row = 0; row < distance.length; row++) {
            for (int column = 0; column < distance[row].length; column++) {
                if (distance[row][column] == 0) continue;
                addEdge(this.cities.get(row), this.cities.get(column), distance[row][column]);
            }
        }
        
    } // end constructor
    
    public void addVertex(String city) {
        /* This method adds a new vertex to the graph. It adds the city to the cities ArrayList,
         * and re-does the adjacency matrix to include the new vertex.
         * It assumes that the new vertex has no edges by default.
         * If the given city already exists as a vertex, a runtime exception is thrown.*/
        if (this.cities.indexOf(city) != -1) throw new DuplicateVertexException();
        
        this.cities.add(city);
        
        int[][] temp = new int[this.am.length + 1][this.am.length + 1];
        // This for loop copies all values of am into a new, larger matrix that can hold the new vertex.
        for (int row = 0; row < this.am.length; row++) {
            for (int column = 0; column < this.am[row].length; column++) {
                temp[row][column] = this.am[row][column];
            }
        }
        this.am = temp;
    } //end addVertex
    
    public void addEdge(String city1, String city2, int distance) {
        /* This method adds an edge between two vertices with a specified weight.
         * If either of the two cities do not exist in the graph, a
         * VertexNotFoundException is thrown.*/
        
        try {
            int city1Pos = this.cities.indexOf(city1);
            int city2Pos = this.cities.indexOf(city2);
            
            this.am[city1Pos][city2Pos] = distance;
            this.am[city2Pos][city1Pos] = distance;
            
        } catch (IndexOutOfBoundsException e) {
            throw new VertexNotFoundException();
        }
    } // end addEdge
    
    public void deleteVertex(String city) {
        /* Removes a specified vertex from both the cities ArrayList and the adjacency matrix.
         * If the specified vertex does not exist in the graph, throws VertexNotFoundException;*/
        
        if (this.cities.indexOf(city) == -1) throw new VertexNotFoundException();
        
        int index = this.cities.indexOf(city);
        this.cities.remove(city);
        
        int[][] temp = new int[this.am.length - 1][this.am.length - 1];
        // This for loop copies all of the values in am, except for the values for the deleted vertex.
        for (int row = 0; row < this.am.length; row++) {
            for (int column = 0; column < this.am[row].length; column++) {
                if (row == index || column == index) continue;
                temp[row][column] = this.am[row][column];
            }
        }
        this.am = temp;
    } // end deleteVertex
    
    public void deleteEdge(String city1, String city2) {
        /* Removes the specified edge from the adjacency matrix.
         * If either of the cities do not exist in the graph,
         * a VertexNotFoundException is thrown.*/
        
        try {
            int city1Pos = this.cities.indexOf(city1);
            int city2Pos = this.cities.indexOf(city2);
            
            this.am[city1Pos][city2Pos] = 0;
            this.am[city2Pos][city1Pos] = 0;
        } catch (IndexOutOfBoundsException e) {
            throw new VertexNotFoundException();
        }
    } // end deleteEdge
    
    public void printVertices() {
        // This method uses an enhanced for loop to print all of the vertices in the graph.
        System.out.print("Vertices: ");
        
        for (String city: cities) {
            System.out.print(city);
            System.out.print(", ");
        }
        System.out.println();
        System.out.println();
    } // end printVertices
    
    public void printEdges() {
        /* This method prints all of the edges in the graph. It traverses the adjacency matrix,
         * and any value that is above zero (i.e. an edge exists there) it prints.
         * If it reaches the center diagonal (where both the column and the row are the same vertex)
         * it will break to the next vertex.
         * This is because the adjacency matrix is fully symmetrical along the center diagonal.*/
        System.out.println("The edges are: ");
        
        for (int row = 0; row < this.am.length; row++) {
            for (int column = 0; column < this.am[row].length; column++) {
                if (row == column) break;
                if (this.am[row][column] > 0) {
                    System.out.print(this.cities.get(column) + " --> ");
                    System.out.print(this.cities.get(row) + ": ");
                    System.out.println(this.am[row][column] + " miles");
                }
            }
        }
    } // end printEdges
    
    public void getSize() {
        // This method prints out the number of vertices and edges in the graph.
        
        int numOfVertices = this.cities.size();
        int numOfEdges = 0;
        
        for (int row = 0; row < this.am.length; row++) {
            for (int column = 0; column < this.am[row].length; column++) {
                if (this.am[row][column] > 0) numOfEdges++;
            }
        }
        System.out.println("Vertices: " + numOfVertices + " Edges: " + (numOfEdges/2));
        // Note: In the above line, numOfEdges is divided by 2 because every Adjacency Matrix is symmetrical along the middle diagonal.
        
    } // end getSize
    
    public void getNeighbors(String city) {
        /* This method returns all of the vertices that are connected by edges
         * to the specified node.
         * If the vertex cannot be found in the graph, prints that "The vertex could not be found"*/
        
        System.out.print("The neighbors of " + city + " are: ");
        
        if (this.cities.indexOf(city) == -1) {
            System.out.println("The requested vertex could not be found");
            return;
        }
        int cityPos = this.cities.indexOf(city);
        
        for (int row = 0; row < this.am.length; row++) {
            if (this.am[row][cityPos] > 0) {
                System.out.print(this.cities.get(row) + ", ");
            }
        }
        System.out.println();
    } // end getNeighbors
    
    public void getDegree(String city) {
        /* This method returns the total number of edges a vertex has.
         * If the vertex cannot be found in the graph, a VertexNotFoundException is thrown.*/
        
        if (this.cities.indexOf(city) == -1) {
            System.out.println("The degree of " + city + " is: " + "The requested vertex could not be found");
            return;
        }
        int cityPos = this.cities.indexOf(city);
        
        int degree = 0;
        for (int row = 0; row < this.am.length; row++) {
            if (this.am[row][cityPos] > 0) degree++;
        }
        System.out.println("The degree of " + city + " is: " + degree);
    } // end getDegree
    
    public boolean isEmpty() {
        /* This method checks if there are any vertices. If there are none,
         * that implies the Graph is empty, so returns true. Else, returns false.*/
        
        return (this.cities.isEmpty());
    } // end isEmpty
    
    public void BFS() {
        /* This method performs Depth-First Traversal with the help of a helper method
         * to print all of the vertices in the graph. If the graph is empty,
         * the method simply returns with nothing printed.*/
        if (isEmpty()) return;
        
        ArrayList<String> visited = new ArrayList<String>();
        System.out.print("Breadth-First Traversal: ");
        System.out.print(this.cities.get(0) + ", ");
        BFSHelper(visited, this.cities.get(0));
        System.out.println();
    } // end BFS
    
    void BFSHelper(ArrayList<String> visited, String city) {
        /* Recursive helper method for BFS. It uses a PriorityQueue data structure
         * and for loops to print out all of the neighbors of the current vertex.
         * For parameters, it takes in an ArrayList of visited cities, and the current vertex.*/
        
        PriorityQueue<String> q = new PriorityQueue<String>();
        
        int cityPos = this.cities.indexOf(city);
        
        for (int row = 0; row < this.am.length; row++) {
            
            if ((this.am[row][cityPos] > 0) && (visited.indexOf(this.cities.get(row)) == -1)) {
                
                if (visited.indexOf(this.cities.get(row)) == -1) {
                    System.out.print(this.cities.get(row) + ", ");
                    visited.add(city);
                    q.add(this.cities.get(row));
                }
            }
        }
        
        for (String str: q) {
            BFSHelper(visited, str);
        }
    } // end BFSHelper
    
    public void DFS() {
        /* This method performs depth-first traversal with the help of a helper method
         * to print out all of the vertices of the graph.
         * If the graph is empty, it simply returns with nothing printed.*/
        if (isEmpty()) return;
        
        ArrayList<String> visited = new ArrayList<String>();
        System.out.print("Depth-First Traversal: ");
        System.out.print(this.cities.get(0) + ", ");
        DFSHelper(visited, this.cities.get(0));
        System.out.println();
    } // end DFS
    
    void DFSHelper(ArrayList<String> visited, String city) {
        /* This is the recursive helper method for DFS.
         * Instead of using a stack structure, it uses recursion to print all of the
         * vertices. For parameters, it takes in an ArrayList of visited vertices, the current vertex*/
        
        int cityPos = this.cities.indexOf(city);
        
        for (int row = 0; row < this.am.length; row++) {
            
            if ((this.am[row][cityPos] > 0) && (visited.indexOf(this.cities.get(row)) == -1)) {
                
                if (visited.indexOf(this.cities.get(row)) == -1) {
                    System.out.print(this.cities.get(row) + ", ");
                    visited.add(city);
                    DFSHelper(visited, this.cities.get(row));
                }
            }
        }
    } // end DFSHelper
    
    public void printAdjMatrix() {
        /* This method prints out the current Adjacency Matrix
         * It is not specified in the assignment, but was added to help in development.*/
        
        for (int row = 0; row < this.am.length; row++) {
            for (int column = 0; column < this.am[row].length; column++) {
              System.out.print(this.am[row][column] + " ");
            }
            System.out.println();
        }
        System.out.println();
    } // end printAdjMatrix
    
    public String toString() {
        // Custom toString method
        
        return super.toString();
    } // end toString
    
    public boolean equals(GraphOfCities g2) {
        /* Custom equals method. If the cities ArrayLists and
         * adjacency matrices are not equal in any way, returns false.
         * Else, returns true.*/
        
        if (!(this.cities.equals(g2.cities))) return false;
        
        for (int row = 0; row < this.am.length; row++) {
            for (int column = 0; column < this.am[row].length; column++) {
              if (!(this.am[row][column] == g2.am[row][column])) return false;
            }
        }
        
        return true;
    } // end equals
    
    class DuplicateVertexException extends RuntimeException {
        /* Because of the way most of the methods in the GraphOfCities class are implemented,
         * duplicate vertices will cause most methods to malfunction.
         * Therefore, a custom exception has been made to disallow duplicate vertices.*/
        
        public DuplicateVertexException() {
            super("That vertex already exists in this GraphOfCities.");
        }
    } // end DuplicateVertexException class
    
    class VertexNotFoundException extends RuntimeException {
        // This custom exception is to handle cases where the requested vertex does not exist in the GraphOfCities
        
        public VertexNotFoundException() {
            super("The requested vertex could not be found in the GraphOfCities");
        }
    } // end VertexNotFoundException
    
} // end GraphOfCities class
