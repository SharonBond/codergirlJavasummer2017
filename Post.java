public class Post
{
    private static int increasePost = 1;
    private  int postNumber; 
    private String content; 
    private String website; 
    private String name; 

    public Post (String name, String content, String website)
    { this.postNumber = increasePost; 
        increasePost ++; 
        this.name =  name; 
        this.content = content; 
        this.website = website; 
    }

    public  void printPost()
    {
        System.out.println("Post Number " + postNumber + "."); 
        System.out.println("This post was presented by " + name );
        System.out.println( content );
        System.out.println(website);
        System.out.println(""); 

        //System.out.println(postNumber); 
        //System.out.println(name); 
        //System.out.println(content); 
        //System.out.println(website); 

    }
    public int getPostNumber()
    { return postNumber; } 

    public String getContent ()
    {return content;} 

    public String getWebsite()
    {return website;} 

    public String getName()
    { return name;}

}
