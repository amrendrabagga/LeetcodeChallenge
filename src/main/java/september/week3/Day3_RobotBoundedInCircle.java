package september.week3;

public class Day3_RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        if (instructions.length() == 0)
            return false;
        int x = 0;
        int y = 0;
        String dir = "North";
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                switch (dir) {
                    case "North":
                        y += 1;break;
                    case "South":
                        y -= 1;break;
                    case "East":
                        x += 1;break;
                    case "West":
                        x -= 1;break;

                }
            }
            else if (c == 'L') {
                if (dir.equals("North"))
                    dir = "West";
                else if (dir.equals("South"))
                    dir = "East";
                else if (dir.equals("East"))
                    dir = "North";
                else dir = "South";
            }
            else {
                if (dir.equals("North"))
                    dir = "East";
                else if (dir.equals("South"))
                    dir = "West";
                else if (dir.equals("East"))
                    dir = "South";
                else dir = "North";
            }
        }

        if (x == 0 && y == 0)
            return true;
        return !dir.equals("North");
    }
}
