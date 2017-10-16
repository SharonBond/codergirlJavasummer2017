public class User 
{ 
    private String userName;
    private String email ;
    private String lastName;
    private String firstName;
    private String avatar;

    public User (String userName,String avatar , String lastName, String firstName, String email)
    { 
        this.userName = userName; 
        this.email = email; 
        this.lastName = lastName; 
        this.firstName = firstName; 
        this.avatar = avatar; 

    } 

    public String getUserName()
    { return userName; } 

    public String getEmail ()
    {return email;} 

    public String getLastName()
    {return lastName;} 

    public String getFirstName()
    { return firstName;}

    public String getAvatar()
    {return avatar;} 

    public void printUser() {
        System.out.println("User:"+ userName);
        System.out.println("Name:" + firstName + " " + lastName);
        System.out.println("Avatar:" + avatar);
        System.out.println("Email:" + email);
    }

    public static void main (String [] args)
    {     /* Create trhee objects using constructor */
        //User AnnaBanana = new User ("AnnaBanana", "http://weknowyourdreams.com/images///banana/banana-08//.jpg", "Anna", "Bell", "Ms.Anna.Bell@gmail.com" );
        // User MsSparklePrincess89 = new User("MsSparklePrincess89","http://pcosdiva.com/wp//-content/uploads///2016/04/sparkle-logo.png", "Jeff", "Tanner","Ms.Anna.Bell@gmail//.com" );
        // User whereintheworldiscarmensandiego = new User ("whereintheworldiscarmensandiego", "https//://a86ad5ac63c1cca559d1-79da6faba5b566b0b230640b13bfaff7.ssl.cf5.rackcdn//.com/programs/shows/where//-on-earth-is-carmen-sandiego/cast-large--57978c6af041d", "Jamie", "Biggerstaff", "Jamie@Biggerstaff//.com"); 

        User [] userInfo = new User [3];
        userInfo [0] = new User ("AnnaBanana", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcStog6FUxuYG9Zj09gXrOoF2fnj8oVxMUa3vM-B9QYPjShqdrxG",  "Bell", "Anna", "Ms.Anna.Bell@gmail.com"); 
        userInfo [1] = new User ("MsSparklePrincess89","https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZyfw8enoTuJy9TRg1dPr6YptIxYmbkL4NvFO3EX98eilrN2rwXg", "Tanner", "Jeff","BurgersbyJeff@gmail.com"); 
        userInfo [2] = new User ("whereintheworldiscarmensandiego", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcYSwcEX8nHOne-YDQ_-vUY0UgOfB9XLPKHAFgSTbII27CO9FIgw", "Biggerstaff", "Jamie", "Jamie@Biggerstaff.com");

        for (int l=0; l < userInfo.length; l ++)
        { userInfo[l].printUser();
            System.out.println(""); 
        } 

        //System.out.println(userInfo [0].getUserName()); 

        //System.out.println(); 
        // userInfo [0].printUser(); 
        //   System.out.println(); 
        //userInfo [1].printUser(); 
        // System.out.println(); 

        //  System.out.println();
        //userInfo [2].printUser(); 

        //  }


        Post [] post = new Post [5]; 
        post [0] = new Post (userInfo[0].getUserName(), "Vegas is amazing! Can't wait to post pics!",  ""); 
        post [1] = new Post (userInfo[0].getUserName(), "Had to pawn my camera. And my phone. And my husband. Craps is way too fun.",  ""); 
        post [2] = new Post (userInfo[1].getUserName(), "Of COURSE it rains on my wedding day. Sing it Alanis.",  ""); 
        post [3] = new Post (userInfo[1].getUserName(), "I'm telling you, weather IS controlled by the government.",  "www.weather.gov"); 
        post [4] = new Post (userInfo[2].getUserName(), "Weird Al 2018 tour dates have been announced!!", "www.weirdal.com" ); 

        for (int i=0; i < post.length; i ++)
        { post[i].printPost();

        } 

        //System.out.println(post[0].getWebsite());   

     
    }

}