import java.awt.Point;
import java.util.Stack;
import java.util.Vector;

public class Professor implements Runnable{
    @Override
    public void run() {
        // TODO Auto-generated method stub
        Stack<Point> points = Repository.getInstance().getPoints();
        Stack<Line> lines = Repository.getInstance().getLines();
        Vector<Double> distanceVal2 = new Vector<Double>();
        Line line;
        boolean runloop=true;
        Vector<Integer> removeIndex= new Vector<Integer>();
        while (runloop)
        {
            System.out.println("Data in points stack");
            for(int i=0;i< points.size();i++)
            {
                System.out.println(points.get(i).getX() +","+ points.get(i).getY());
            }
            System.out.println("Data in Lines stack");
            for(int i=0;i<lines.size();i++)
            {
                System.out.println("line "+i+":");
                for(int j=0;j<4;j++)
                {
                    System.out.print(lines.get(i).getLine()[j]+"    ");
                }
                System.out.println("");

            }
            int count = 0;
            for(int i=0;i<lines.size()-1;i++)
            {
                if(lines.peek().getLine()[2]==lines.get(i).getLine()[0]&&
                        lines.peek().getLine()[3]== lines.get(i).getLine()[1])
                {
                	count++;
                    removeIndex.add(i);

                }
                else if(lines.peek().getLine()[2]==lines.get(i).getLine()[2]&&
                        lines.peek().getLine()[3]== lines.get(i).getLine()[3])
                {
                	count++;
                    removeIndex.add(i);

                }
                else
                {
                    System.out.println("count  "+count);
                }
                System.out.println("COUNT IS: " + count);
                if(count >=4)
                {
                    System.out.println("Remove a line ");
                    for(int r=0;r<removeIndex.size();r++)
                    {
                        //lines.remove(r);

                    }
                    removeIndex.clear();
                    System.out.println("Remove a point ");
                    for(int z=0;z<points.size();z++)
                    {
                        if(lines.peek().getLine()[2]==points.get(z).getX()&&
                                lines.peek().getLine()[3]== points.get(z).getY())
                        {
                            points.remove(z);
                        }
                    }
                    lines.clear();

                    count=0;

                    Repository.getInstance().setBool(true);
                    System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    boolean run=true;
                    for(int l=0;l< points.size();l++)
                    {
                        distanceVal2.clear();
                        for (int j = 0; j < points.size(); j++) {
                            if(l==j){
                                distanceVal2.add(Double.MAX_VALUE);
                            }
                            else {
                                int x = (int) points.get(j).getX();
                                int y = (int) points.get(j).getY();
                                int topX = (int) points.get(l).getX();
                                int topY = (int) points.get(l).getY();
                                int Xdiff = (x - topX) * (x - topX);
                                int Ydiff = (y - topY) * (y - topY);
                                System.out.println("FIRST LOOP");
                                double distance = Math.sqrt(Xdiff + Ydiff);
                                if (topX == x) {

                                } else {
                                    distanceVal2.add(distance);
                                }
                            }
                        }
                        double smallest = Integer.MAX_VALUE;
                        for (int z = 0; z < distanceVal2.size(); z++) {
                            if (smallest > distanceVal2.elementAt(z)) {
                                //update smallest
                                smallest = distanceVal2.elementAt(z);
                            }
                            System.out.println("Value is: " + distanceVal2.elementAt(z));
                        }
                        for (int z = 0; z < distanceVal2.size(); z++) {
                            if (smallest == distanceVal2.elementAt(z)) {
                                int q = (int) points.get(z).getX();
                                int y = (int) points.get(z).getY();
                                int topX = (int) points.get(l).getX();
                                int topY = (int) points.get(l).getY();
                                line = new Line(topX, topY, q, y);
                                System.out.println("Adding line");
                                Repository.getInstance().addLine(line);
                                //distanceVal2.clear();
                                break;
                            }

                        }

                    }
                }
            }
            double[] lineCheck=new double[4];
            double[] lineCheck2=new double[4];
            Vector<Integer> indexDel = new Vector<Integer>();
            for(int i=0;i<lines.size();i++)
            {
                lineCheck=lines.get(i).getLine();
                for(int j=0;j<lines.size();j++)
                {
                    lineCheck2 = lines.get(j).getLine();
                    if(i==j)
                    {}
                    else if(i!=j)
                    {
                        if(lineCheck[0]==lineCheck2[0]&&lineCheck[1]==lineCheck2[1])
                        {
                            if(lineCheck[2]==lineCheck2[2]&&lineCheck[3]==lineCheck2[3])
                            {
                                indexDel.add(j);
                                lines.remove(j);
                            }
                        }
                        else if(lineCheck[0]==lineCheck2[2]&&lineCheck[1]==lineCheck2[3])
                        {
                            if(lineCheck[2]==lineCheck2[0]&&lineCheck[3]==lineCheck2[1])
                            {
                                indexDel.add(j);
                                lines.remove(j);
                            }
                        }
                        else if (lineCheck[2]==lineCheck2[2]&&lineCheck[3]==lineCheck2[3])
                        {
                            if(lineCheck[0]==lineCheck2[0]&&lineCheck[1]==lineCheck2[1])
                            {
                                indexDel.add(j);
                                lines.remove(j);
                            }
                        }
                        else if (lineCheck[2]==lineCheck2[0]&&lineCheck[3]==lineCheck2[1])
                        {
                            if(lineCheck[0]==lineCheck2[2]&&lineCheck[1]==lineCheck2[3])
                            {
                                indexDel.add(j);
                                lines.remove(j);
                            }
                        }

                    }
                }

            }





        }


        try {
            Thread.sleep(1000);
        }catch(Exception e) {

        }

    }

}
