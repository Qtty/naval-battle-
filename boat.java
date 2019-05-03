
// public class boat
// {
//     public static void main(String[] args)
//     {
//         Boat b = new Boat("4323");
//         String coor[] = {"2","5"};
//         System.out.println(b);
//         System.out.println(b.have_coor(coor));
//         /*System.out.println(b.removePart("23"));
//         System.out.println(b.removePart("24"));
//         System.out.println(b);*/
//     }
// }

class boat
{
    private int parts[][];
    private static int[] boats[][][] = { 
                                         { {{0,0},{0,1}}                         , {{0,0},{1,0}} },
                                         { {{0,0},{0,1},{0,2}}                   , {{0,0},{1,0},{2,0}} },
                                         { {{0,0},{0,1},{0,2},{0,3}}             , {{0,0},{1,0},{2,0},{3,0}} },
                                         { {{0,0},{0,1},{0,2},{0,3},{0,4}}       , {{0,0},{1,0},{2,0},{3,0},{4,0}} },
                                         { {{0,0},{0,1},{0,2},{1,1}}             , {{0,0},{1,0},{2,0},{1,1}} , {{0,0},{0,1},{0,2},{-1,-1}} , {{0,0},{0,1},{1,1},{-1,-1}} },
                                         { {{0,0},{0,1},{0,2},{1,1},{1,2},{1,3}} , {{0,0},{1,0},{2,0},{0,1},{1,1},{-1,1}} }
                                        };
    private static int numberOfBoats = 0;
    
    public boat(String cord)
    {
        parts = buildBoat(cord);
        numberOfBoats++;
    }

    public String toString()
    {
        String out = new String();
        for (int i[]:parts)
        {
            for (int j:i) out += String.valueOf(j) + " ";
            out += "\n";
        }
        return out;
    }

    private int[][] removeElement(int index)
    {
        int tmp[][] = new int[parts.length - 1][];
        
        for (int i = 0,j = 0;i < parts.length;i++)
        {
            if (i != index) tmp[j++] = parts[i];
        }
        return tmp;
    }

    public Boolean removePart(String cord)
    {
        int point[] = new int[2],tmpParts[][] = new int[parts.length][],index = 0;
        Boolean hit = false;
        
        point[0] = Integer.parseInt(String.valueOf(cord.charAt(0))); 
        point[1] = Integer.parseInt(String.valueOf(cord.charAt(1))); 
        for (int i[]:parts)
        {
            if (i[0] == point[0] && i[1] == point[1])
            {
                hit = true;
                break;
            }
            index++;
        }
        if (hit)
        {
            parts = removeElement(index);
            return true;
        }
        return false;
    }

    public Boolean destroyed()
    {
        if (parts.length != 0) return false;
        numberOfBoats--;
        return true;
    }

    public static int checkBoats()
    {
        return numberOfBoats;
    }

    public static Boolean buildableBoat(String cord)
    {
        int b,s,tmp[] = new int[2],startingPoint[] = new int[2];

        b = Integer.parseInt(String.valueOf(cord.charAt(0)));
        s = Integer.parseInt(String.valueOf(cord.charAt(1)));
        startingPoint[0] = Integer.parseInt(String.valueOf(cord.charAt(2)));
        startingPoint[1] = Integer.parseInt(String.valueOf(cord.charAt(3)));
        if (b != 4) s %= 2;
        for(int i[]:boats[b][s])
        {
            tmp[0] = startingPoint[0]+i[0];
            tmp[1] = startingPoint[1]+i[1];
            if (tmp[0] > 9 || tmp[0] < 0 || tmp[1] > 9 || tmp[1] < 0) return false;
        }

        return true;
    }

    public static int[][] buildBoat(String cord)
    {
        int b,s,c = 0,tmp[][],startingPoint[] = new int[2];

        b = Integer.parseInt(String.valueOf(cord.charAt(0)));
        s = Integer.parseInt(String.valueOf(cord.charAt(1)));
        startingPoint[0] = Integer.parseInt(String.valueOf(cord.charAt(2)));
        startingPoint[1] = Integer.parseInt(String.valueOf(cord.charAt(3)));
        if (b != 4) s %= 2;
        tmp = new int[boats[b][s].length][];
        for(int i[]:boats[b][s])
        {
            tmp[c] = new int[] {startingPoint[0]+i[0],startingPoint[1]+i[1]};
            c++;
        }

        return tmp;
    }

    public Boolean have_coor(String[] coor)
    {
        int tmp[] = {Integer.parseInt(coor[0]),Integer.parseInt(coor[1])};

        for (int i[]:parts)
        {
            if (i[0] == tmp[0] && i[1] == tmp[1]) return true;
        }

        return false;
    }
    public int[][] getParts(){
        return this.parts;
    }
    
}