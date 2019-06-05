import java.io.*;
import java.util.*;
public class LRU {
	public static int getElement(Stack<Integer> Queue,int Sim[]) {		
		int min=Sim[0];
		int minInd=Queue.lastIndexOf(Sim[0]);
		for(int i:Sim) {
			int x2=Queue.lastIndexOf(i);
			if(x2<minInd) {
				min=i;
				minInd=x2;
			}			
		}
		return min;
	}
	public static boolean contains(int Sim[],int key) {
		for(int i=0;i<Sim.length;i++) {
			if(Sim[i]==key)return true;
		}
		return false;
	}
	public static void Simulate(int REF[],int f) {
		float hitCtr=0,pg=0;
		float p=REF.length;
		int newline=0;
		Stack<Integer> Queue=new Stack<Integer>();
		int Sim[]=new int[f];
		int ptr=0;
		for(int i=0;i<f;i++) {
			Sim[i]=-1;
		}
		for(int i=0;i<p;i++) {					
			Queue.push(REF[i]);
			if(Sim[f-1]==-1) {	
				if(!contains(Sim,REF[i])) {
					Sim[ptr]=REF[i];				
					System.out.print("MISS)\t");
					pg++;
					ptr++;
				}else {System.out.print("HIT )\t");hitCtr++;}
				
				for(int it=0;it<f;it++)
				{	newline++;					
					System.out.print(Sim[it]+" ");
					if(newline%f==0)System.out.println();						
				}
				
			}else {				
				if(newline%f==0)System.out.println();
								
				if(!contains(Sim,REF[i])) {
					System.out.print("MISS)\t");
					pg++;
				int element=getElement(Queue,Sim);
					for(int itr=0;itr<f;itr++) {
						if(Sim[itr]==element) {
							Sim[itr]=REF[i];
							break;							
						}
					}
					for(int ii=0;ii<f;ii++) {
						System.out.print(Sim[ii]+" ");						
						newline++;
					}					
				}else {
					System.out.print("HIT )\t");
					hitCtr++;
					for(int ii=0;ii<f;ii++) {
						System.out.print(Sim[ii]+" ");						
						newline++;
					}
				}
		}
	}
		float ratio=hitCtr/p;
		System.out.println("\nNo. of Hits:"+hitCtr);
		System.out.println("Hit Ratio:"+ratio);
		System.out.println("No. of page faults:"+pg);
}
public static void main(String args[]) {
	Scanner scn=new Scanner(System.in);
	int p,f;
	System.out.println("Enter number of pages");
	p=scn.nextInt();
	System.out.println("Enter number of frames");
	f=scn.nextInt();
	System.out.println("Enter Reference string");
	int referenceString[]=new int[p];
	for(int i=0;i<p;i++) {
		referenceString[i]=scn.nextInt();
	}
	System.out.println("SIMULATION:");
	Simulate(referenceString,f);
}
}/*
*take inputs ...ref string,no. of frames,no of pages
*pass to simulate
*simulate(ref,f){
*sim=new int[i]...init them all to -1
*for(i <p;i++){
*Queue.push(ref[i]);
*if(sim not full){
*	if(!contains ref[i] in sim)
*	{sim[ptr]=ref[i]
*	ptr++;
*	}else{
*		//contains:
*		skip
*	}
*}else if full{
*element=getelement(Queue,sim);
		*{
		*min=sim[0];
		*ind=Integer.MAX_VALUE;
		*for(int i:sim){
		*if(Queue.lastIndexOf(i)<ind)
		*ind=Queue.lastIndexOf(i);
		*min=i;
		*}
		*}
*}
*}
*}
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*
*/