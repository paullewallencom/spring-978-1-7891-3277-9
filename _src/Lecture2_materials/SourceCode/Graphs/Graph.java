package com.company;
import java.util.List;

/**
 * Created by Navdeep on 18-02-2016.
 */
public interface Graph {

    enum GraphType{
        DIRECTED,
        UNDIRECTED
    }

    GraphType TypeofGraph();
    void addEdge(int v1, int v2);

    void addEdge(int v1, int v2, int weight);

    int getWeightedEdge(int v1, int v2);

    List<Integer> getAdjacentVertices(int v);

    int getNumVertices();

    int getIndegree(int v);
}
