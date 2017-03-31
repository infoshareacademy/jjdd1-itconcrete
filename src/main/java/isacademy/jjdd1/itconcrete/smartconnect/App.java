package isacademy.jjdd1.itconcrete.smartconnect;

import isacademy.jjdd1.itconcrete.smartconnect.calculator.Path;
import isacademy.jjdd1.itconcrete.smartconnect.calculator.PathFinder;

public class App 
{
    public static void main( String[] args )
    {
        PathFinder pathFinder = new PathFinder();
        int pathLength = pathFinder.calculatePathLength(new Path(10, 20));

        System.out.println( "Path length: " + pathLength );
    }
}
