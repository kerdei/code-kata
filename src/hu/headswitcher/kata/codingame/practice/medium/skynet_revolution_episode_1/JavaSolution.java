import java.util.*;

class Link {

    Integer node1;
    Integer node2;

    public Link(Integer node1, Integer node2) {
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public String toString() {
        return "Link{" + node1 + "->" + node2 + "}";
    }


    void printOutLinkAsResult() {
        System.out.println(node1 + " " + node2);
    }
}

class Player {


    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways

        ArrayList<Link> links = new ArrayList<>();
        ArrayList<Integer> gateways = new ArrayList<>();

        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            Link currentLink = new Link(N1, N2);
            links.add(currentLink);
            System.err.println(currentLink);
        }
        for (int i = 0; i < E; i++) {
            gateways.add(in.nextInt());
        }


        /*
         affactedLinks : store all links between gateways and between nodes
         affacted = needs to be closed.
         */

        ArrayList<Link> affactedLinks = new ArrayList<>();
        for (Link link : links) {
            if (gateways.contains(link.node1) || gateways.contains(link.node2)) {
                affactedLinks.add(link);
            }
        }

        // game loop
        while (true) {
         /*
         Each turn remove a link from the affactedLinks and print out the result.
         if the Skynet Agent is on a affactedLinks then we should print and remove that one instead of the first one.
          */

         int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

         boolean isAgentOnAffactedLink = false;
         int agentIsOnAffactedLink = 0;

         for ( int i  = 0 ; i < affactedLinks.size() ; i++){
             Link link = affactedLinks.get(i);
             if (link.node2 == SI || link.node1 == SI) {
                 isAgentOnAffactedLink = true;
                 agentIsOnAffactedLink = i;
                 break;
             }
         }
            if (affactedLinks.size() > 0) {
                if (isAgentOnAffactedLink){
                    affactedLinks.get(agentIsOnAffactedLink).printOutLinkAsResult();
                    affactedLinks.remove(agentIsOnAffactedLink);
                }
                else {
                    affactedLinks.get(0).printOutLinkAsResult();
                    affactedLinks.remove(0);
                }
            } else{
                System.err.println("Something went wrong, affactedLinks size is 0");
            }
        }
    }
}