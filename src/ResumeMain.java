import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class ResumeMain {

	public void add(){

		resume natObj = new resume();
		ResumeMainFinal tableObj = new ResumeMainFinal();

		String email,  name, educ = null, toExit = "exit";

		ArrayList<String> eduAchieve = new ArrayList<String>();
		ArrayList<String> experiance = new ArrayList<String>();
		ArrayList<String> skill = new ArrayList<String>();

		int counter = 0;
		int countEduc = 0;
		int countExp = 0;
		int countSkill = 0;
		Scanner input = new Scanner(System.in);
		
		
		System.out.println("Enter the Name:   ");
		name = input.nextLine();
		System.out.println("Enter the email:   ");
		email = input.nextLine();

		/*Validate the email address*/
		while(counter !=3){
			if(!(email.contains("@") && email.contains("."))){
				System.out.println("Wrong Email please Enter email again:  ");
				email = input.nextLine();
				counter++;
			}
			else{break;}
		}

		System.out.println("Enter the Education and type \"exit\" to continue:   ");
		do{

			countExp +=1;
			if (countExp !=10){ /*To restrict a max of 10 Educational Background*/

				educ = input.nextLine();
				if(!(educ.equalsIgnoreCase(toExit))){
					eduAchieve.add(educ); /*store in the array list*/
				}
			}
		}while (!(toExit.equalsIgnoreCase(educ)));

		System.out.println("Enter the Experiance and type \"exit\" to continue:   ");
		do{
			countEduc +=1;
			if (countEduc !=10){

				educ = input.nextLine();
				if(!(educ.equalsIgnoreCase(toExit))){
					experiance.add(educ);
				}
			}
		}while (!(toExit.equalsIgnoreCase(educ)));

		System.out.println("Enter the skills and type \"exit\" :   ");
		do{
			countSkill +=1;
			if (countSkill !=20){

				educ = input.nextLine();
				if(!(educ.equalsIgnoreCase(toExit))){
					skill.add(educ);
				}
			}
		}while (!(toExit.equalsIgnoreCase(educ)));


		System.out.println("             YOUR DATA IS ");
		System.out.println("================================================");
		System.out.println();
		System.out.println(name);
		System.out.println(email);
		System.out.println();

		System.out.println("Education");
		System.out.println();
		Iterator Eduitr=eduAchieve.iterator();  
		while(Eduitr.hasNext()){  
			System.out.println(Eduitr.next());  
		}  
		System.out.println();
		System.out.println("Experiance");
		System.out.println();
		Iterator Expitr=experiance.iterator();  
		while(Expitr.hasNext()){  
			System.out.println(Expitr.next());  
		}  

		System.out.println();
		System.out.println("Skills");
		System.out.println();
		Iterator skillitr=skill.iterator();  
		while(skillitr.hasNext()){  
			System.out.println(skillitr.next());  
		}  

		input.close();


		//tableObj.promptTable(name, email, eduAchieve, experiance, skill);
		natObj.prompt(name, email, eduAchieve,experiance,skill);

	}	

}