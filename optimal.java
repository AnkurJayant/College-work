import java.util.*;
import java.io.*;
import java.io.*;
public class optimal {
	public static int getElement(int SIM[],int REF[],int index) {
		int ele=SIM[0];
		int ind=0;		
		boolean flag=false;
		for(int i1:SIM) {
			flag=false;
			for(int i=index;i<REF.length;i++) {
				if(i1==REF[i]) {
					flag=true;
					if(i>ind) {
						ind=i;
						ele=REF[i];												
					}
				}
			}
			if(flag==false) {				
				return i1;
			}
		}
		return ele;
	}
	public static boolean contains(int key,int Sim[]) {
		for(int i:Sim) {
			if(i==key) {
					return true;
			}			
		}
		return false;
	}	
	public static void Simulate(int  REF[],int f) {
		int p=REF.length;
		int ptr=0;
		int newline=0;
		float pageFaults=0,hits=0;
		int Sim[]=new int[f];
		for(int i=0;i<f;i++) {
			Sim[i]=-1;
		}
		for(int i=0;i<p;i++) {
			if(Sim[f-1]==-1) {
				if(!contains(REF[i],Sim)) {										
					Sim[ptr]=REF[i];
					if(newline%f==0)System.out.println();
						System.out.print("Miss");
						pageFaults++;
					for(int ii=0;ii<f;ii++) {
						System.out.print(Sim[ii]+" ");newline++;
					}
					ptr++;
				}else {
					if(newline%f==0)System.out.println();
						System.out.print("Hit ");
						hits++;
					for(int ii=0;ii<f;ii++) {
						System.out.print(Sim[ii]+" ");newline++;
					}
				}
			}else {
				if(!contains(REF[i],Sim)) {
					int ele=getElement(Sim,REF,i);
					for(int itr=0;itr<Sim.length;itr++) {
						if(ele==Sim[itr]) {
							Sim[itr]=REF[i];
						}
					}
					if(newline%f==0)System.out.println();
					System.out.print("Miss");
					pageFaults++;
					for(int ii=0;ii<f;ii++) {
						System.out.print(Sim[ii]+" ");newline++;
					}
				}else {
					if(newline%f==0)System.out.println();
					System.out.print("Hit ");
					hits++;
					for(int ii=0;ii<f;ii++) {
						System.out.print(Sim[ii]+" ");newline++;
					}
				}
			}
		}
		System.out.println("Page Faults:"+pageFaults);
		System.out.println("No. of hits:"+hits);
		System.out.println("Hit ratio:"+hits/p);	
	}
	public static void main(String args[]) {
		
		Scanner scn=new Scanner(System.in);
		System.out.println("Enter number of pages:");
		int p=scn.nextInt();
		int REF[]=new int[p];
		System.out.println("Enter number of frames:");
		int f=scn.nextInt();
		System.out.println("Enter reference string:");
		for(int i=0;i<p;i++) {
			REF[i]=scn.nextInt();
		}
		System.out.println("Simulation:");
		Simulate(REF,f);
	}
}
