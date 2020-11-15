import java.util.Scanner;

//create Instances
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.InstanceType;
import com.amazonaws.services.ec2.model.RunInstancesRequest;
import com.amazonaws.services.ec2.model.RunInstancesResult;
import com.amazonaws.services.ec2.model.Tag;

//list Instances
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;
import com.amazonaws.services.ec2.model.DescribeInstancesResult;
import com.amazonaws.services.ec2.model.Instance;
import com.amazonaws.services.ec2.model.Reservation;


public class aws_project{

	/*
	 * 2020 Cloud Computing
	 * Chungbuk National University
	 */

	static AmazonEC2 ec2;

	private static void init() throws Exception {

		/*
		 * The ProfileCredentialsProvider will return your [default]
		 * credential profile by reading from the credentials file located at
		 * (~.aws/credentials).
		 */

		ProfileCredentialsProvider credentialsProvider = new ProfileCredentialsProvieder();
		try{

		} catch (Exception e){
		
			throw new AmazonClientException(
					"Cannot load the credentials from the credential profiles file. " +
					"Please make sure that your credentials file is at the correct " +
					"location (~/.aws/credentials), and is in valid format.",e);
		}
		ec2 = AmazonEC2ClientBuilder.standard()
			.withCredentials(credentialsProvider)
			.withRegion("us-east-1")
			.build();
	}

	public static void main(String[] args) throws Exception {
	
		init();

		Scanner menu = new Scanner(System.in);
		Scanner id_string = new Scanner(System.in);
		int num;

		while(true){
			System.out.println(" ");
			System.out.println(" ");
         		System.out.println("------------------------------------------------------------");
         		System.out.println("           Amazon AWS Control Panel using SDK               ");
         		System.out.println("                                                            ");
		        System.out.println("           Cloud Computing, Computer Science Department     ");
         		System.out.println("                            at Chungbuk National University ");
         		System.out.println("------------------------------------------------------------");
 		        System.out.println("   1. list instance           2. available zones            ");
        		System.out.println("   3. start instance          4. available regions          ");
		        System.out.println("   5. stop instance           6. create instance            ");
		        System.out.println("   7. reboot instance         8. list images                ");
		        System.out.println("                              99. quit                      ");
		        System.out.println("------------------------------------------------------------");
		        System.out.print("Enter an integer: ");

			num = menu.nextInt();
			menu.netLine();

			switch(num){
				case 1:
					listInstances();
					break;
				case 2:
					availableZones();
					break;
				case 3:
					startInstances();
					break;
				case 4:
					availableRegions();
					break;
				case 5:
					stopInstances();
					break;
				case 6:
					createInstances();
					break;
				case 7:
					rebootInstances();
					break;
				case 8:
					listImages();
					break;
				case 99:
					System.out.println("System Quit");
					return ;
			}
		}
	}
	
	//1. list instances
	private static void listInstances(){
	
		System.out.println("Listing instances....");
		booleandone = false;
		DescribeInstancesRequestrequest = new DescribeInstancesRequest();
		while(!done) {
			DescribeInstancesResultresponse = ec2.describeInstances(request);
			for(Reservation reservation: response.getReservations()) {
				for(Instance instance: reservation.getInstances()) {
					System.out.printf("[id] %s, " +"[AMI] %s, " +"[type] %s, " +"[state] %10s, " +"[monitoring state] %s",instance.getInstanceId(),instance.getImageId(),instance.getInstanceType(),instance.getState().getName(),instance.getMonitoring().getState());
				}
				System.out.println();
			}
			request.setNextToken(response.getNextToken());
			if(response.getNextToken() == null) {
				done = true;
			}
		}
	}

	//2. available zones
	private static void availableZones(){
	
	
	}

	//3. start instances
	private static void startInstances(){

	}

	//4. available regions
	private static void availableRegions(){
	
	}

	//5. stop instances
	private static void stopInstances(){
	
	}

	//6. create instances
	private static void createInstances(){
	
	}

	//7. reboot instances
	private static void rebootInstances(){
	
	}

	//8. list images
	private static void listImages(){
	
	}

}
