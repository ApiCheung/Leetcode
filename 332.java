//332 reconstruct Itinerary
class solution{
	//think about the topo sort
	public List<String> findItinerary(List<List<String>> tickets){
		List<String> res = new ArrayList<>();
		Map<String, PriorityQueue<String>> g = new HashMap<>();
		buildGraph(tickets, g);
		dfs(g, res, "JFK");
		return res;
	}
	private void dfs(Map<String, PriorityQueue<String>> g, List<String> res, String from){
		PriorityQueue<String> arrivals = g.get(from);
		while(arrivals != null && !arrivals.isEmpty()){
			String to = arrivals.poll();
			dfs(g, res, to);
		}
		res.add(0,from);
	}
/* to build a graph with topo sort using the priorityQueu*/
	private void buildGraph(List<List<String>> tickets, Map<String, PriorityQueue<String>> g){
		for(List<Sring> travel : tickets){
			String from = travel.get(0);
			String to = travel.get(1);

			if(!g.containsKey(from)){
				g.put(from, new PriorityQueue<>());

			}

			g.get(from).offer(to);
		}
	}
}
