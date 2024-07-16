#include<stdio.h>
#include<string.h>
typedef struct Book
{
	int id;
	char name[50];
	char author[50];
	char category[50];
	double price;
	int rating;
}Book;
int ctr=0;
void storeHdata(Book*);
//void storeData(Book*,int);
void displayData(Book*);
void display1(Book*,int);
void addBookData(Book*,int);
int searchByID(Book*,int);
int searchByName(Book*,char*);
int searchByAuthor(Book*,char*);
int searchByCategory(Book*,char*);
void deleteBook(Book*,int);
void SortData(Book*);
void updateData(Book*);
void TopBook(Book*);
void main()
{
	Book b[50];
	int choice;
		//storeHdata(b);
		printf("-------------------------------------------------------MENU-----------------------------------------------------------");
	do
	{ 
			printf("\n Enter your choice \n1.store \n2.Display \n3.AddBook \n4.Delete \n5.SearchData \n6.UpdateData \n7.SortBook\n8.Top 3 Books\n0.Exit\n ");
			scanf("%d",&choice);
				switch(choice)
		{
			case 1:
				{
					storeHdata(b);
	          //	storeData(b,50);
				}
				break;
			case 2:
		    	{
		    		displayData(b);
				}	
				break;
			case 3:
			    {
			    	addBookData(b,50);
			    	break;
				}
			case 4:
		     	{
		     		int ID;
		     		printf("\nEnter the book ID to search: ");
					scanf("%d",&ID);
					int index = searchByID(b,ID);
					if(index==-1)
					{
						printf("\nBook not found\n");
					}
					else
					{
						deleteBook(b,index);
				   
					    break;	
					}
							
				}
			case 5:
		    	{
		    		int choice1;
		    		printf("---------------------------------------------------**SearchData**-------------------------------------------------");
	            	do
					{
	            		
		            	printf("\n Enter your choice \n1.Id \n2.Name \n3.Author Name \n4.category \n0.Exit\n  ");
		            	scanf("%d",&choice1);
	            	
		            		switch(choice1)
						{
							case 1:
								{
							    	int ID;
								    printf("\nEnter the book ID to search: ");
								    scanf("%d",&ID);
								   
									int index=searchByID(b,ID);
									if(index==-1)
									{
									  	printf("\n The book is not found.");
									}
									else
									{
										display1(b,index);
									}
									break;
								}
								case 2:
									{
										 char Name[50];
										printf("\nEnter the Book Name to search: ");
										scanf("%s",Name);
										int index=searchByName(b, Name);
										if(index==-1)
										{
										  	printf("\n The book is not found.");
										}
										else
										{
											display1(b,index);
										}
										break;	
									}
								case 3:
							    	{
									  	char AName[50];
										printf("\nEnter the book Author Name to search: ");
									    scanf("%s",&AName);
									    int index=searchByAuthor(b,AName); 
									    if(index==-1)
										{
										  	printf("\n The book is not found.");
										}
										else
										{
											display1(b,index);
										}
									    break;
									}
								case 4:
								   {
								   	    char category[50];
										printf("\nEnter Category of book to search: ");
										scanf("%s",category);
									    int index=searchByCategory(b,category);
									    if(index==-1)
										{
										  	printf("\n The book is not found.");
										}
										else
										{
											display1(b,index);
										}
									    break;
								   }  	
					    }	
					
					}
					while(choice1!=0);
					printf("\n Invalid choice!!\n");
				}
				case 6:
				{
					updateData(b);
					break;
						
				}	
				case 7:
				{
					SortData(b);
					break;
				}
				case 8:
				{
					TopBook(b);
					break;
				}	
		}
	}
	while(choice!=0);
	printf("Invalid choice!!");

}
void storeHdata(Book*b)
{
	 printf("-------------------------------------------------------Store Hardcoded Value--------------------------------------------");

	//for book1
	b[0].id=1;
	strcpy(b[0].name,"Atomic");
	strcpy(b[0].author,"James");
	strcpy(b[0].category,"Habits");
	b[0].price=650;
	b[0].rating=2;
	ctr++;
	
	//for book2
	b[1].id=2;
	strcpy(b[1].name,"Hooked");
	strcpy(b[1].author,"Eyal");
	strcpy(b[1].category,"Habits");
	b[1].price=900;
	b[1].rating=5;
	ctr++;
	
	//for book3
	b[2].id=3;
	strcpy(b[2].name,"Spark");
	strcpy(b[2].author,"John");
	strcpy(b[2].category,"Health");
	b[2].price=650;
	b[2].rating=4;
	ctr++;
	
	//for book4
	b[3].id=4;
	strcpy(b[3].name,"Attitude");
	strcpy(b[3].author,"John");
	strcpy(b[3].category,"Growth");
	b[3].price=250;
	b[3].rating=5;
	ctr++;
	
	//for book5
	b[4].id=5;
	strcpy(b[4].name,"zero_to_one");
	strcpy(b[4].author,"Peter");
	strcpy(b[4].category,"Business");
	b[4].price=1250;
	b[4].rating=5;
	ctr++;	
}
void storeData(Book* b,int s)
{
	for(int i=0;i<s;i++)
	{
		if(ctr!=s)
		{
			printf("\tEnter book ID: ");
			scanf("%d",&b[ctr].id);
			printf("\t Enter Book name: ");
			scanf("%s",&b[ctr].name);
			printf("\t Enter Author Name:");
			scanf("%s",&b[ctr].author);
			printf("\t Enter Category: ");
			scanf("%s",&b[ctr].category);
			printf("\t Enter Price: ");
			scanf("%lf",&b[ctr].price);
			printf("\t Enter rating:");
			scanf("%d",&b[ctr].rating);
			
			ctr++;
			printf("%d",ctr);
		}
		else
		{
			printf("Books are full");
		}
	}		
}
void displayData(Book* b)
{
	printf("---------------------------------------------------**Display**-------------------------------------------------");
	int i;
	for(i=0;i<ctr;i++)
	{
		printf("\n\t Book ID:%d",b[i].id);
		printf("\t Book name :%s",b[i].name);
		printf("\t Book author:%s ",b[i].author);
		printf("\t Book category:%s",b[i].category);
		printf("\t Book price:%lf",b[i].price);
		printf("\t Book rating:%d",b[i].rating);	
		printf("\n");	
	}	
}
void display1(Book* b,int i)
{
	    printf("\n\t book ID :%d",b[i].id);
		printf("\t Name :%s",b[i].name);	
		printf("\t Author Name :%s",b[i].author);
		printf("\t   Category :%s",b[i].category);
		printf("\t   Price :%lf",b[i].price);
		printf("\t   Rating :%d",b[i].rating);
}
void addBookData(Book* b,int s)
{
		printf("---------------------------------------------------**AddBook**----------------------------------------------------------");
		if(ctr<s)
		{
			printf("\n Enter book ID: ");
			scanf("%d",&b[ctr].id);
			printf("\t Enter Book name: ");
			scanf("%s",&b[ctr].name);
			printf("\t Enter Author Name:");
			scanf("%s",&b[ctr].author);
			printf("\t Enter Category: ");
			scanf("%s",&b[ctr].category);
			printf("\t Enter Price: ");
			scanf("%lf",&b[ctr].price);
			printf("\t Enter rating:");
			scanf("%d",&b[ctr].rating);
			
			ctr++;
			printf("%d",ctr);
		}
		else
		{
			printf("Books are full");
		}	
}
int searchByID(Book* b,int id)
{
	int i;
	for(i=0;i<ctr;i++)
	{
		if(b[i].id==id)
		{
			return i;
		}
	}
		return -1;
}
int searchByName(Book* b,char* Name)
{
	int i;
	int len=strlen(Name);
	for(i=0;i<ctr;i++)
	{
		if(strncmp(b[i].name,Name,len)==0)
		{
			return i;
		}
	}
		return -1;
}
int searchByAuthor(Book* b,char* AName)                       
{
	int i;
	int len=strlen(AName);
	for(i=0;i<ctr;i++)
	{
		if(strncmp(b[i].author,AName,len)==0)
		{
			return i;
		//	display1(b,i);	
		}
	}
	return -1;		
}
int searchByCategory(Book* b,char* category)
{
	int i;
	int len=strlen(category);
	for(i=0;i<ctr;i++)
	{
		if(strncmp(b[i].category,category,len)==0)
		{
			return i;
		   	//display1(b,i);
		}
	}
	return -1;
}
void deleteBook(Book* b,int index)
{
	printf("---------------------------------------------------**DeleteData**-------------------------------------------------");

	
	while(index<ctr)
	{
		b[index]=b[index+1];
		index++;
	}
	ctr--;
	printf("\n Book deleted successfully!\n");
}
void SortData(Book* b)
{
	printf("---------------------------------------------------**SortData**------------------------------------------------------------");
	int choice;
	printf("\n Enter choice for sorting by \n1.price:  \n2.rating \n ");
	scanf("%d",&choice);
		if(choice==1)
		{
		    int i,j;
			for(i=0;i<ctr;i++)
	  		{
				for(j=i+1;j<ctr;j++)
				{
					if(b[i].price>b[j].price)
					{
						Book temp=b[i];
					    b[i]=b[j];
					   b[j]=temp;
				    }
				}
			}
			printf("\n Sorted array for price\n");
		}
		else if(choice==2)
		{
		    int i,j;
			for(i=0;i<ctr;i++)
	  		{
				for(j=i+1;j<ctr;j++)
				{
					if(b[i].rating>b[j].rating)
					{
						Book temp=b[i];
					    b[i]=b[j];
					    b[j]=temp;	  
				    }
		     	}
		   }	
		   printf("\nSorted array for rating \n");
        }
}
void updateData(Book* b)
{
	printf("-----------------------------------------------------------**UpdateData**----------------------------------------------------------");
	int choice;
	double new_price;
	printf("Enter choice for update by \n1.price:  \n2.rating");
	scanf("%d",&choice);
		if(choice==1)
	{
		int nID;
		printf("Enter ID ");
		scanf("%d",&nID);
		int index=searchByID(b,nID);
		if(index<ctr)
		{
			printf("Enter new price to add in book");
			scanf("%lf",&new_price);
			b[index].price=new_price;
			display1(b,index);
		}
    }
		else if(choice==2)
		{
				int n_rating;
			printf("Enter ID to change the price");
			scanf("%d",&n_rating);
			int index=searchByID(b,n_rating);
			if(index<ctr)
			{
				printf("Enter new Rating to add in book");
				scanf("%d",&n_rating);
				b[index].rating=n_rating;
				display1(b,index);
			}	
    	}
}
void TopBook(Book* b)
{
	printf("---------------------------------------------------**Top 3 Books**------------------------------------------------------------");
	int choice,index;
	printf("\n Enter choice for checking top 3 books with : \n1.price:  \n2.rating \n ");
	scanf("%d",&choice);
		if(choice==1)
		{
		    int i,j;
			for(i=0;i<ctr;i++)
	  		{
				for(j=i+1;j<ctr;j++)
				{
					if(b[i].price<b[j].price)
					{
						Book temp=b[i];
					    b[i]=b[j];
					   b[j]=temp;
				    }
				}
			}
			printf("\n Top Three Books by price\n");
			for(i=0;i<3;i++)
			{
				display1(b,i);
			}
		}
		else if(choice==2)
		{
		    int i,j;
			for(i=0;i<ctr;i++)
	  		{
				for(j=i+1;j<ctr;j++)
				{
					if(b[i].rating<b[j].rating)
					{
						Book temp=b[i];
					    b[i]=b[j];
					    b[j]=temp;	
					    
				    }
		     	}
		   }	
		   printf("\nTop Three Books by rating \n");
		   for(i=0;i<3;i++)
			{
				display1(b,i);
			}
        }
}



