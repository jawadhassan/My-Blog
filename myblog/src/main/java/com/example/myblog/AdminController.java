package com.example.myblog;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.myblog.data.PostRepository;
import com.example.myblog.entities.Post;
import com.example.myblog.entities.ResponseObj;
import com.example.myblog.entities.Root;
import com.example.myblog.entities.User;

@Controller
@RequestMapping("/admin")
public class AdminController {

	PostRepository postRepository;

	@Autowired
	public AdminController(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@GetMapping("/")
	public String postsPage(Model model) {

		List<Post> posts = new ArrayList<Post>();

		this.postRepository.findAll().forEach(i -> posts.add(i));

		model.addAttribute("posts", posts);

		return "posts";
	}
	
	@GetMapping("/dashboard")
	public String DashboardPage() {
		return "dashboard";
	}
	
	@GetMapping("/users")
	public String getUsersPage() {
		return "users";
	}
	

	@PostMapping(path="/check/{check}", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Root check(@PathVariable("check") String check,@RequestBody MultiValueMap paramMap)  {
		
	    System.out.println("Check"+paramMap);	
	    
	 //   String decodeURL = decode(requestData);  
     //   System.out.println("Decoded URL: "+decodeURL); 
		
		String result = "{\r\n"
				+ "  \"data\": [\r\n"
				+ "    [\r\n"
				+ "      \"Tiger Nixon\",\r\n"
				+ "      \"System Architect\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"5421\",\r\n"
				+ "      \"2011/04/25\",\r\n"
				+ "      \"$320,800\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Garrett Winters\",\r\n"
				+ "      \"Accountant\",\r\n"
				+ "      \"Tokyo\",\r\n"
				+ "      \"8422\",\r\n"
				+ "      \"2011/07/25\",\r\n"
				+ "      \"$170,750\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Ashton Cox\",\r\n"
				+ "      \"Junior Technical Author\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"1562\",\r\n"
				+ "      \"2009/01/12\",\r\n"
				+ "      \"$86,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Cedric Kelly\",\r\n"
				+ "      \"Senior Javascript Developer\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"6224\",\r\n"
				+ "      \"2012/03/29\",\r\n"
				+ "      \"$433,060\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Airi Satou\",\r\n"
				+ "      \"Accountant\",\r\n"
				+ "      \"Tokyo\",\r\n"
				+ "      \"5407\",\r\n"
				+ "      \"2008/11/28\",\r\n"
				+ "      \"$162,700\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Brielle Williamson\",\r\n"
				+ "      \"Integration Specialist\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"4804\",\r\n"
				+ "      \"2012/12/02\",\r\n"
				+ "      \"$372,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Herrod Chandler\",\r\n"
				+ "      \"Sales Assistant\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"9608\",\r\n"
				+ "      \"2012/08/06\",\r\n"
				+ "      \"$137,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Rhona Davidson\",\r\n"
				+ "      \"Integration Specialist\",\r\n"
				+ "      \"Tokyo\",\r\n"
				+ "      \"6200\",\r\n"
				+ "      \"2010/10/14\",\r\n"
				+ "      \"$327,900\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Colleen Hurst\",\r\n"
				+ "      \"Javascript Developer\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"2360\",\r\n"
				+ "      \"2009/09/15\",\r\n"
				+ "      \"$205,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Sonya Frost\",\r\n"
				+ "      \"Software Engineer\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"1667\",\r\n"
				+ "      \"2008/12/13\",\r\n"
				+ "      \"$103,600\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Jena Gaines\",\r\n"
				+ "      \"Office Manager\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"3814\",\r\n"
				+ "      \"2008/12/19\",\r\n"
				+ "      \"$90,560\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Quinn Flynn\",\r\n"
				+ "      \"Support Lead\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"9497\",\r\n"
				+ "      \"2013/03/03\",\r\n"
				+ "      \"$342,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Charde Marshall\",\r\n"
				+ "      \"Regional Director\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"6741\",\r\n"
				+ "      \"2008/10/16\",\r\n"
				+ "      \"$470,600\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Haley Kennedy\",\r\n"
				+ "      \"Senior Marketing Designer\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"3597\",\r\n"
				+ "      \"2012/12/18\",\r\n"
				+ "      \"$313,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Tatyana Fitzpatrick\",\r\n"
				+ "      \"Regional Director\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"1965\",\r\n"
				+ "      \"2010/03/17\",\r\n"
				+ "      \"$385,750\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Michael Silva\",\r\n"
				+ "      \"Marketing Designer\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"1581\",\r\n"
				+ "      \"2012/11/27\",\r\n"
				+ "      \"$198,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Paul Byrd\",\r\n"
				+ "      \"Chief Financial Officer (CFO)\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"3059\",\r\n"
				+ "      \"2010/06/09\",\r\n"
				+ "      \"$725,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Gloria Little\",\r\n"
				+ "      \"Systems Administrator\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"1721\",\r\n"
				+ "      \"2009/04/10\",\r\n"
				+ "      \"$237,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Bradley Greer\",\r\n"
				+ "      \"Software Engineer\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"2558\",\r\n"
				+ "      \"2012/10/13\",\r\n"
				+ "      \"$132,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Dai Rios\",\r\n"
				+ "      \"Personnel Lead\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"2290\",\r\n"
				+ "      \"2012/09/26\",\r\n"
				+ "      \"$217,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Jenette Caldwell\",\r\n"
				+ "      \"Development Lead\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"1937\",\r\n"
				+ "      \"2011/09/03\",\r\n"
				+ "      \"$345,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Yuri Berry\",\r\n"
				+ "      \"Chief Marketing Officer (CMO)\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"6154\",\r\n"
				+ "      \"2009/06/25\",\r\n"
				+ "      \"$675,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Caesar Vance\",\r\n"
				+ "      \"Pre-Sales Support\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"8330\",\r\n"
				+ "      \"2011/12/12\",\r\n"
				+ "      \"$106,450\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Doris Wilder\",\r\n"
				+ "      \"Sales Assistant\",\r\n"
				+ "      \"Sydney\",\r\n"
				+ "      \"3023\",\r\n"
				+ "      \"2010/09/20\",\r\n"
				+ "      \"$85,600\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Angelica Ramos\",\r\n"
				+ "      \"Chief Executive Officer (CEO)\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"5797\",\r\n"
				+ "      \"2009/10/09\",\r\n"
				+ "      \"$1,200,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Gavin Joyce\",\r\n"
				+ "      \"Developer\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"8822\",\r\n"
				+ "      \"2010/12/22\",\r\n"
				+ "      \"$92,575\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Jennifer Chang\",\r\n"
				+ "      \"Regional Director\",\r\n"
				+ "      \"Singapore\",\r\n"
				+ "      \"9239\",\r\n"
				+ "      \"2010/11/14\",\r\n"
				+ "      \"$357,650\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Brenden Wagner\",\r\n"
				+ "      \"Software Engineer\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"1314\",\r\n"
				+ "      \"2011/06/07\",\r\n"
				+ "      \"$206,850\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Fiona Green\",\r\n"
				+ "      \"Chief Operating Officer (COO)\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"2947\",\r\n"
				+ "      \"2010/03/11\",\r\n"
				+ "      \"$850,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Shou Itou\",\r\n"
				+ "      \"Regional Marketing\",\r\n"
				+ "      \"Tokyo\",\r\n"
				+ "      \"8899\",\r\n"
				+ "      \"2011/08/14\",\r\n"
				+ "      \"$163,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Michelle House\",\r\n"
				+ "      \"Integration Specialist\",\r\n"
				+ "      \"Sydney\",\r\n"
				+ "      \"2769\",\r\n"
				+ "      \"2011/06/02\",\r\n"
				+ "      \"$95,400\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Suki Burks\",\r\n"
				+ "      \"Developer\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"6832\",\r\n"
				+ "      \"2009/10/22\",\r\n"
				+ "      \"$114,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Prescott Bartlett\",\r\n"
				+ "      \"Technical Author\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"3606\",\r\n"
				+ "      \"2011/05/07\",\r\n"
				+ "      \"$145,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Gavin Cortez\",\r\n"
				+ "      \"Team Leader\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"2860\",\r\n"
				+ "      \"2008/10/26\",\r\n"
				+ "      \"$235,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Martena Mccray\",\r\n"
				+ "      \"Post-Sales support\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"8240\",\r\n"
				+ "      \"2011/03/09\",\r\n"
				+ "      \"$324,050\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Unity Butler\",\r\n"
				+ "      \"Marketing Designer\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"5384\",\r\n"
				+ "      \"2009/12/09\",\r\n"
				+ "      \"$85,675\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Howard Hatfield\",\r\n"
				+ "      \"Office Manager\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"7031\",\r\n"
				+ "      \"2008/12/16\",\r\n"
				+ "      \"$164,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Hope Fuentes\",\r\n"
				+ "      \"Secretary\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"6318\",\r\n"
				+ "      \"2010/02/12\",\r\n"
				+ "      \"$109,850\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Vivian Harrell\",\r\n"
				+ "      \"Financial Controller\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"9422\",\r\n"
				+ "      \"2009/02/14\",\r\n"
				+ "      \"$452,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Timothy Mooney\",\r\n"
				+ "      \"Office Manager\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"7580\",\r\n"
				+ "      \"2008/12/11\",\r\n"
				+ "      \"$136,200\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Jackson Bradshaw\",\r\n"
				+ "      \"Director\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"1042\",\r\n"
				+ "      \"2008/09/26\",\r\n"
				+ "      \"$645,750\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Olivia Liang\",\r\n"
				+ "      \"Support Engineer\",\r\n"
				+ "      \"Singapore\",\r\n"
				+ "      \"2120\",\r\n"
				+ "      \"2011/02/03\",\r\n"
				+ "      \"$234,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Bruno Nash\",\r\n"
				+ "      \"Software Engineer\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"6222\",\r\n"
				+ "      \"2011/05/03\",\r\n"
				+ "      \"$163,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Sakura Yamamoto\",\r\n"
				+ "      \"Support Engineer\",\r\n"
				+ "      \"Tokyo\",\r\n"
				+ "      \"9383\",\r\n"
				+ "      \"2009/08/19\",\r\n"
				+ "      \"$139,575\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Thor Walton\",\r\n"
				+ "      \"Developer\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"8327\",\r\n"
				+ "      \"2013/08/11\",\r\n"
				+ "      \"$98,540\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Finn Camacho\",\r\n"
				+ "      \"Support Engineer\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"2927\",\r\n"
				+ "      \"2009/07/07\",\r\n"
				+ "      \"$87,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Serge Baldwin\",\r\n"
				+ "      \"Data Coordinator\",\r\n"
				+ "      \"Singapore\",\r\n"
				+ "      \"8352\",\r\n"
				+ "      \"2012/04/09\",\r\n"
				+ "      \"$138,575\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Zenaida Frank\",\r\n"
				+ "      \"Software Engineer\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"7439\",\r\n"
				+ "      \"2010/01/04\",\r\n"
				+ "      \"$125,250\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Zorita Serrano\",\r\n"
				+ "      \"Software Engineer\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"4389\",\r\n"
				+ "      \"2012/06/01\",\r\n"
				+ "      \"$115,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Jennifer Acosta\",\r\n"
				+ "      \"Junior Javascript Developer\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"3431\",\r\n"
				+ "      \"2013/02/01\",\r\n"
				+ "      \"$75,650\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Cara Stevens\",\r\n"
				+ "      \"Sales Assistant\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"3990\",\r\n"
				+ "      \"2011/12/06\",\r\n"
				+ "      \"$145,600\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Hermione Butler\",\r\n"
				+ "      \"Regional Director\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"1016\",\r\n"
				+ "      \"2011/03/21\",\r\n"
				+ "      \"$356,250\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Lael Greer\",\r\n"
				+ "      \"Systems Administrator\",\r\n"
				+ "      \"London\",\r\n"
				+ "      \"6733\",\r\n"
				+ "      \"2009/02/27\",\r\n"
				+ "      \"$103,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Jonas Alexander\",\r\n"
				+ "      \"Developer\",\r\n"
				+ "      \"San Francisco\",\r\n"
				+ "      \"8196\",\r\n"
				+ "      \"2010/07/14\",\r\n"
				+ "      \"$86,500\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Shad Decker\",\r\n"
				+ "      \"Regional Director\",\r\n"
				+ "      \"Edinburgh\",\r\n"
				+ "      \"6373\",\r\n"
				+ "      \"2008/11/13\",\r\n"
				+ "      \"$183,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Michael Bruce\",\r\n"
				+ "      \"Javascript Developer\",\r\n"
				+ "      \"Singapore\",\r\n"
				+ "      \"5384\",\r\n"
				+ "      \"2011/06/27\",\r\n"
				+ "      \"$183,000\"\r\n"
				+ "    ],\r\n"
				+ "    [\r\n"
				+ "      \"Donna Snider\",\r\n"
				+ "      \"Customer Support\",\r\n"
				+ "      \"New York\",\r\n"
				+ "      \"4226\",\r\n"
				+ "      \"2011/01/25\",\r\n"
				+ "      \"$112,000\"\r\n"
				+ "    ]\r\n"
				+ "  ]\r\n"
				+ " }";
		System.out.println("This is"+check.toString());
		ArrayList<String> objectResult = new ArrayList<String>();
		objectResult.add("Angelica");
		
		objectResult.add("Ramos");
		objectResult.add("System Architect");
		objectResult.add("London");
		objectResult.add("9th Oct 09");
		objectResult.add("$2,875");
		
		
		Root root = new Root();
		root.draw = 1;
		root.recordsTotal = 10;
		root.recordsFiltered = 2;
		root.data = new ArrayList<List<String>>();
		root.data.add(objectResult);
		//requestData.data = new ArrayList(objectResult);
		//return requestData;
		return root;
	}

	
	@PostMapping(path = "/savepost")
	public @ResponseBody Post savePost(@RequestBody Post requestData)  {

//		Thread.sleep(2000);

		Post post = requestData;
		//post.setTitle("HTML POST");
		//post.setContent(body);
		post.setSummary("Summary");
		post.setCreatedAt(new Date());
		postRepository.save(post);
		return post;
	}
	
	@PatchMapping(path = "/editpost/{id}/", consumes = MediaType.TEXT_HTML_VALUE)
	public @ResponseBody Post editPost(@PathVariable("id")  Long id,@RequestBody String body) {
		 
		
		 Optional<Post> record = this.postRepository.findById(Long.valueOf(id));
		 this.postRepository.findById(Long.valueOf(id)); if(record.isPresent()) {
		 
			 if(body != null && !body.isEmpty()) { 
				 Post post = record.get(); 
				 post.setContent(body); 
				 return this.postRepository.save(post); 
				 
			  }
		  
		  }
		 
		  
		  return null;
		 
		
	}
	
	@DeleteMapping(path = "/deletepost/{id}/")
	public ResponseEntity<?> deletePost(@PathVariable("id")  Long id) {
				
		this.postRepository.deleteById(id);
		
		ResponseObj apiResponse = new ResponseObj();

		apiResponse.setMessage("Post with ID: " + id + " has been deleted");
		apiResponse.setStatus(HttpStatus.OK.value());
		apiResponse.setTimeStamp(System.currentTimeMillis());

		
	    return new ResponseEntity<ResponseObj>(apiResponse, HttpStatus.OK);
	}


	@GetMapping("/fetchpost")
	public @ResponseBody Optional<Post> fetchPostbyId(@RequestParam("id") Long id) {
 
	   Optional<Post> post =    this.postRepository.findById(Long.valueOf(id)); 
	   this.postRepository.findById(Long.valueOf(id)); 
	   if(post.isPresent()) {
		   return post; 
	   }
		
	   return null;
	}

	/*
	 * @GetMapping("/") public String adminPage() { return "admin"; }
	 */

	
    public String decode(String url)  
    {  
              try {  
                   String prevURL="";  
                   String decodeURL=url;  
                   while(!prevURL.equals(decodeURL))  
                   {  
                        prevURL=decodeURL;  
                        decodeURL= java.net.URLDecoder.decode(decodeURL, "UTF-8" );  
                   }  
                   return decodeURL;  
              } catch (UnsupportedEncodingException e) {  
                   return "Issue while decoding" +e.getMessage();  
              }  
    }  
	
}
