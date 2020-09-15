import java.util.Scanner;

class Main {
  public static void main(String[] args) {
  Scanner in = new Scanner(System.in);
  System.out.println("Welcom, to BattleShip!! A great fun game you can play with another person!! Please choose the parameters of the grid.");
  System.out.println("First write the amount of rows you would like in your game");
  int r = in.nextInt();
  System.out.println("Secondly write the amount of columns you would like in your game");
  int c = in.nextInt();
boolean[][] playerships1 = new boolean[r][c];
boolean[][] playerships2 = new boolean [r][c];
boolean[][] printgrid1 = new boolean [r][c];
boolean[][] printgrid2 = new boolean [r][c];



System.out.println("How many 2 place ships would you like");
int x = in.nextInt();
System.out.println("How many 3 place ships would you like");
int y = in.nextInt();
System.out.println("How many 4 place ships would you like");
int z = in.nextInt();
int totalships = x*2 + y*3 + z*4;
int totalp1 = 0;
int totalp2 = 0;
int [] change = new int [3];
change[0]=x;
change[1]=y;
change[2]=z;

for(int i = 0; i < change.length; i++){
  int coordinates = change[i] * (i + 2);
 
   while (coordinates>0) {
    System.out.println("What row would you like to place your" + " " + (i+2) + " " + "unit ship"+"(Player 1)");
    int m = in.nextInt();
    System.out.println("What column would you like to place your" + " " + (i+2) + " " + "unit ship"+ "(Player 1)");
    int n = in.nextInt();
    
if(0<=n && n<c && 0<=m && m<r){
  coordinates-=1;
  playerships1[m][n]= true;
  printGrid(playerships1);
}
   
else{
  System.out.println("Sorry that was not a point in the designated grid, please try again");
} 

   

  }
}

   try{
     Thread.sleep(3000);
   }
   catch(Exception e){}

    System.out.print("\033[H\033[2J"); 
        System.out.flush();

  
for(int i = 0; i<change.length; i++){
  int coordinates = change[i] * (i + 2);
 
   while (coordinates>0) {
    System.out.println("What row would you like to place your" + " " + (i+2) + " " + "unit ship"+"(Player 2)");
    int m = in.nextInt();
    System.out.println("What column would you like to place your" + " " + (i+2) + " " + "unit ship"+ "(Player 2)");
    int n = in.nextInt();
    
if(0<=n && n<c && 0<=m && m<r){
  coordinates-=1;
  playerships2[m][n]= true;
  printGrid(playerships2);
}
   
else{
  System.out.println("Sorry that was not a point in the designated grid, please try again");
} 

   

  }
  }
  try{
     Thread.sleep(3000);
   }
   catch(Exception e){}

    System.out.print("\033[H\033[2J"); 
        System.out.flush();

while (true) {

    System.out.println();

      printGrid(printgrid1);

        System.out.println();
        
    

    System.out.println("What row will you choose to bomb? (Player 1)");
    int row = in.nextInt();
    System.out.println("What column will you choose to bomb? (Player 1) ");
    int column = in.nextInt();
 if (row>=r || column>=c || row<0 || column<0){
System.out.println("Sorry, you did not choose one of the designated rows or columns, please try again");
  }

if (row == -1) {
    break;
 }  
 
  else if (row>=0 && row < printgrid1.length && column>=0 && column < printgrid1[0].length && playerships2[row][column] == true ) {
     printgrid1[row][column] = true; 
     totalp1 += 1;
     System.out.println( "It is a hit! Congratulations!");
    if(totalp1 == totalships){
      System.out.println("Congratulations you won the game!");
      break;
    }
  } 
  else{
  System.out.println("Sorry it was a miss, please try again");
   }
     


 try{
     Thread.sleep(1500);
   }
   catch(Exception e){}

    System.out.print("\033[H\033[2J"); 
        System.out.flush();

    System.out.println();

    printGrid(printgrid2);

    System.out.println();

  

  System.out.println("What row will you choose to bomb? (Player 2)");
   row = in.nextInt();System.out.println("What column will you choose to bomb? (Player 2)");
   column = in.nextInt();
  if(row>=r||column>=c||row<0||column<0){
    System.out.println("Sorry, you did not choose one of the designated rows or columns, please try again");
  }

  if(row==-1){
    break;
  }

  else if(row>=0&&row<printgrid2.length&&column>=0&&column<printgrid2[0].length&&playerships1[row][column]==true){
    printgrid2[row][column] = true;
    System.out.println("It is a hit! Congratulations!");
    totalp2+=1;
  
  if(totalp2 == totalships){
      System.out.println("Congratulations you won the game!");
      break;
  }
  }
  else{
    System.out.println("Sorry it was a miss, please try again");
  }
  try{
     Thread.sleep(1500);
   }
   catch(Exception e){}

    System.out.print("\033[H\033[2J"); 
        System.out.flush();
}



  }

  public static void printGrid(boolean[][] ships) {
    System.out.print("  ");
    for (int a = 0; a < ships[0].length; a++) {
      System.out.print(a + "  ");
    }
    System.out.println();

    for (int b = 0; b < ships.length; b++) {
      System.out.print(b + " ");
      for (int a = 0; a < ships[0].length; a++) {
        if (ships[b][a] == true) {
          System.out.print("x  ");
        } else if (ships[b][a] == false) {
          if (a > 9) {
            System.out.print("-   ");
          } else {
            System.out.print("-  ");
          }
        }
      }
      System.out.println();
    }

  }


}
