package routerplan;

import java.util.*;

public class RoutePlanner {

    static HashMap<String, ArrayList<String>> graph;

    public static boolean routeExists(int fromRow, int fromColumn, int toRow, int toColumn,
                                      boolean[][] mapMatrix) {

        String sourceKey = fromRow + "-" + fromColumn;
        String targetKey = toRow + "-" + toColumn;

        if(fromRow < 0 || fromColumn < 0 || toRow < 0 || toColumn < 0) {
            return false;
        }
        if(fromRow >= mapMatrix.length || fromColumn >= mapMatrix[0].length || toRow >= mapMatrix.length || toColumn >= mapMatrix[0].length) {
            return false;
        }
        if(!mapMatrix[fromRow][fromColumn] || !mapMatrix[toRow][toColumn]) {
            return false;
        }
        if(fromRow == toRow && fromColumn == toColumn) {
            return true;
        }
        constructGraph(mapMatrix); //find all the valid neighbors
        return search(sourceKey, targetKey);

        //throw new UnsupportedOperationException("Waiting to be implemented.");
    }

    public static void constructGraph(boolean[][] mapMatrix) {
        graph = new HashMap<>();

        for(int row = 0; row < mapMatrix.length; row++) {
            for(int col = 0; col < mapMatrix[row].length; col++) {
                if(!mapMatrix[row][col]) {
                    continue;
                }
                String currId = row + "-" + col;
                if(row-1 >= 0) {
                    if(mapMatrix[row-1][col]) {
                        addNeighbour(currId, (row-1) + "-" + col);
                    }
                }
                if(row+1 < mapMatrix.length) {
                    if(mapMatrix[row+1][col]) {
                        addNeighbour(currId, (row+1) + "-" + col);
                    }
                }
                if(col-1 >= 0) {
                    if(mapMatrix[row][col-1]) {
                        addNeighbour(currId, row + "-" + (col-1));
                    }
                }
                if(col+1 < mapMatrix[row].length) {
                    if(mapMatrix[row][col+1]) {
                        addNeighbour(currId, row + "-" + (col+1));
                    }
                }
            }
        }
    }

    public static void addNeighbour(String from, String to) {
        if(graph.containsKey(from)) {
            graph.get(from).add(to);
        } else {
            ArrayList<String> neighbour = new ArrayList<>();
            neighbour.add(to);
            graph.put(from, neighbour);
        }
    }

    public static boolean search(String start, String end) {
        LinkedList<String> queue = new LinkedList<>();        // FIFO queue for BFS
        HashSet<String> visited = new HashSet<>();

        queue.add(start);
        visited.add(start);

        String curr;
        while(!queue.isEmpty()) {
            curr = queue.poll();

            if(curr.equals(end)) {
                return true;
            }

            if(!graph.containsKey(curr)) {
                return false;
            }

            for(String next : graph.get(curr)) {
                if(!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        boolean[][] mapMatrix = {
//                {true,  false, false},
//                {true,  true,  false},
//                {false, true,  true}
//        };

        boolean[][] mapMatrix = {
                {true,  false, false, true,  false, false},
                {true,  false, false, true,  false, false},
                {true,  false, true, true,  false, false},
                {true,  true,  true, false, true,  true},
                {false, true,  false,  false, true,  true}
        };

        System.out.println(routeExists(1, 3, 4, 1, mapMatrix));
    }
}
