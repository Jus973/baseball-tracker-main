import java.util.ArrayList;

/**
 * Object that represents the running of a graph. Handles 3d to 2d calculations
 */
public class runGraph {

    private camera c;
    private ArrayList<graphable> gList; //list of points to graph

    private ArrayList<graphable> g; //points to put in graphlist
    private ArrayList<graphableLine> gL; //lines to put in graphlist

    private graphList lGraphList;

    private final double DISTANCE_FIXED = 12;
    private final double WIDTH_OF_BALL = 2.85;
    private final double PIXEL_WIDTH_OF_BALL_AT_DISTANCE_FIXED_AWAY = 131.636;
    private final double focalLength = 55.4256842;

    //takes any graphable object and plots it, using camera

    //create a plot object, graph each axis


    //given camera (which has 3d coords) and an angle, and a fixed FOV, 
    //and a list of graphable objects (also having 3d coords)
    //translate that into a 2d window

    /**
     * Main constructor for the runGraph class
     * @param iC The given camera input, which is a camera object
     * @param graphList The graphlist input which is a list of things that we want to graph
     */
    public runGraph (camera iC, ArrayList<graphable> graphList){
        c = iC;

        gList = new ArrayList<>();

        for (graphable i : graphList) {
            gList.add(i);   
        }
        
        g = new ArrayList<graphable>();
        gL = new ArrayList<graphableLine>();
        
        lGraphList = new graphList(g, gL);

        plotGraph();
    }

    /**
     * Getter method for graphlist
     * @return The graphList 
     */
    public graphList getGraphList (){
        return lGraphList;
    }

    private void plotGraph (){

        //graphing axis
        plot p = new plot(10, 10, 10);
        
        System.out.println("X");
        for (graphableLine i : p.getXAxis()){
            System.out.println(i);
            plotLine(i);
        }
        
        System.out.println("Y");
        for (graphableLine i : p.getYAxis()){
            System.out.println(i);
            plotLine(i);
        }
        
        System.out.println("Z");
        for (graphableLine i : p.getZAxis()){
            System.out.println(i);
            plotLine(i);
        }
        
        //graphing graphList
        for (graphable i : gList){
            plotPoint(i);
        }
        
        //in 2d values
        lGraphList = new graphList(g, gL);

    }


    private void plotPoint (graphable a){ 
        //double x = focalLength * (a.getX() - c.getX()) / (a.getZ() - c.getZ());
        //double y = focalLength * (a.getY() - c.getY()) / (a.getZ() - c.getZ());

        //calculating trigs functions for further use
        // double cp = Math.cos(c.getAngleW());
        // double sp = Math.sin(c.getAngleW());
        // double ct = Math.cos(c.getAngleL());
        // double st = Math.sin(c.getAngleL());

        // double dx = a.getX() - c.getX();
        // double dy = a.getY() - c.getY();
        // double dz = a.getZ() - c.getZ(); 
        // double S, X, Y, Z;

        // S = ((((ct * cp * ct * cp))) + (ct * sp * ct * sp) + (st * st)) / ( - (ct * cp * dx) - (ct * sp * dy) + (st * dz));
        // X = c.getX() + S * (a.getX() - c.getX());
        // Y = c.getY() + S * (a.getY() - c.getY());
        // Z = c.getZ() + S * (a.getZ() - c.getZ());

        // graphable r = new graphable((cp * X) + (sp * Y), (X * sp + Y * cp) * st + Z * ct);
        // // graphable r = new graphable(x, y);
        
        // g.add(r);
    }

    private void plotLine (graphableLine a){

        
        double x = focalLength * (a.getX() - c.getX()) / (a.getZ() - c.getZ());
        double y = focalLength * (a.getY() - c.getY()) / (a.getZ() - c.getZ());

        
        double ex = focalLength * (a.getEX() - c.getX()) / (a.getEZ() - c.getZ());
        double ey = focalLength * (a.getEY() - c.getY()) / (a.getEZ() - c.getZ());
        
        graphableLine r = new graphableLine(x, y, ex, ey);
        gL.add(r);
        
        // double cp = Math.cos(c.getAngleW());
        // double sp = Math.sin(c.getAngleW());
        // double ct = Math.cos(c.getAngleL());
        // double st = Math.sin(c.getAngleL());

        // double dx = a.getX() - c.getX();
        // double dy = a.getY() - c.getY();
        // double dz = a.getZ() - c.getZ(); 
        // double S, X, Y, Z;

        // double edx = a.getEX() - c.getX();
        // double edy = a.getEY() - c.getY();
        // double edz = a.getEZ() - c.getZ(); 
        // double eS, eX, eY, eZ;

        // S = ((((ct * cp * ct * cp))) + (ct * sp * ct * sp) + (st * st)) / ( - (ct * cp * dx) - (ct * sp * dy) + (st * dz));
        // X = c.getX() + S * (a.getX() - c.getX());
        // Y = c.getY() + S * (a.getY() - c.getY());
        // Z = c.getZ() + S * (a.getZ() - c.getZ());
        
        // eS = ((((ct * cp * ct * cp))) + (ct * sp * ct * sp) + (st * st)) / ( - (ct * cp * edx) - (ct * sp * edy) + (st * edz));
        // eX = c.getX() + eS * (a.getEX() - c.getX());
        // eY = c.getY() + eS * (a.getEY() - c.getY());
        // eZ = c.getZ() + eS * (a.getEZ() - c.getZ());

        // graphableLine r = new graphableLine((cp * X) + (sp * Y), (X * sp + Y * cp) * st + Z * ct,  
        //                                     (cp * eX) + (sp * eY), (eX * sp + eY * cp) * st + eZ * ct);

        // System.out.println(r);
        // gL.add(r);
    }


}
