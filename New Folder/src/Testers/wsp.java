package Testers;

import java.io.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import Information.*;
import Information.Exceptions.*;
import LessonObjects.*;
import ResearchObjects.*;
import Users.*;

public class wsp {
	private void printList(List list) {
		for(int i=0; i<list.size(); i++)
			System.out.println(i+1+ ")" +list.get(i));
	}
	public void run() throws IOException, CreditsException {
		PrintWriter pw = new PrintWriter(System.out, true);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		try {
			Data.loadFromFile("a.ser");
			pw.println(" Welcome to the university System! \n Please choose language \n "
					+ "1) Kazakh \n 2) English \n 3) Russian \n ");

			int langNum = Integer.parseInt(br.readLine());
	        String[] language;
	        switch (langNum) {
	            case 1:
	                language = KazakhLanguage;
	                break;
	            case 2:
	                language = EnglishLanguage;
	                break;
	            case 3:
	                language = RussianLanguage;
	                break;
	            default:
	                pw.println("Invalid language choice. Defaulting to English.");
	                language = EnglishLanguage;
	        }
	        menu: while(true) {
	            pw.println(language[0]);
	            User user = User.authenticate(br.readLine(), br.readLine());
	            if(user != null) {
	            	if(user instanceof Student) {
	            	stmenu:	while(true){
	            			pw.println(language[2]);	
	            			pw.println(language[60]);
	                		pw.println(language[44]);	                		
	                		int option = Integer.parseInt(br.readLine());
	                		switch(option) {
	                		case 1:
	                			pw.println(((Student)user).viewCourses());
	                			continue stmenu;
	                		case 2:
	                			printList(((Student)user).viewTeacherInfo());
	                			continue stmenu;
	                		case 3:
	                			pw.println(language[3]);
	                			pw.println(((Student)user).viewMarks(br.readLine(), br.readLine()));
	                			continue stmenu;
	                		case 4:
	                			pw.println(((Student)user).viewTranscript());
	                			continue stmenu;
	                		case 5:
	                			pw.println(language[4]);
	                			pw.println(((Student) user).joinStudentOrganization(br.readLine()));
	                			continue stmenu;
	                		case 6:
	                			pw.println(language[5]);
	                			pw.println(((Student) user).sendRequest(br.readLine()));
	                			continue stmenu;
	                		case 7:
	                			pw.println(language[6]);
	                			pw.println(((Student)user).rateTeacher(br.readLine(), Integer.parseInt(br.readLine())));
	                			continue stmenu;
	                		case 8:
	                			pw.println(language[61]);
	                			pw.println(((Student)user).createStOrg(br.readLine()));
	                			continue stmenu;
	                		case 9:
	                			for(Map.Entry<Course, Attestation> e: ((Student)user).getCourseAttestation().entrySet()) {
	                			pw.println(e.getKey().getCourseName()+ "           " + e.getValue().getFirstAtt() + ""
	                					+ "           " + e.getValue().getSecondAtt() + "           " + e.getValue().getFinalExam());
	                			}
	                			continue stmenu;
	                		case 10:
	                			break menu;
	                		case 30:
	                			for(News n: user.viewNews()) {
	                				pw.println(n.getTopic() + "\n" + n.getContent() );
	                			}
	                			continue stmenu;
	                		case 33:
	                			pw.println(language[37]); 
	                		    String journalName = br.readLine();
	                		    boolean journalFound = false;

	                		    for (Journal journal : Data.getInstance().getJournals()) {
	                		        if (journal.getName().equals(journalName)) {
	                		            journal.subscribe(user);
	                		            journalFound = true;
	                		            pw.println(language[40]);
	                		            break;
	                		        }
	                		    }

	                		    if (!journalFound) {
	                		        pw.println(language[43]);
	                		    }
	                		    continue stmenu;
	                		case 34:
	                		    pw.println(language[37]);
	                		    String unsubscribeJournalName = br.readLine();
	                		    boolean unsubscribeJournalFound = false;
	                		    boolean userIsSubscriber = false;

	                		    for (Journal journal : Data.getInstance().getJournals()) {
	                		        if (journal.getName().equals(unsubscribeJournalName)) {
	                		        	unsubscribeJournalFound = true;
	                		            for (Subscriber subscriber : journal.getSubscribers()) {
	                		                if (subscriber.getUsername().equals(user.getUsername())) {
	                		                    journal.unsubscribe(user);
	                		                    userIsSubscriber = true;
	                		                    pw.println(language[41]);
	                		                    break;  
	                		                }
	                		            }

	                		            if (!userIsSubscriber) {
	                		                pw.println(language[42]);
	                		            }
	                		            break; 
	                		        }
	                		    }

	                		    if (!unsubscribeJournalFound) {
	                		        pw.println(language[43]);
	                		    }
	                		    continue stmenu; 
	                		case 35:
	                			user.setResearcher(true);
	                			pw.println(language[45]);
	                			continue stmenu;
	                		case 36:
	                			user.setResearcher(false);
	                			pw.println(language[46]);
	                			continue stmenu;
	                		case 37:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(((Researcher) user).calculateHindex());
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue stmenu;
	                		case 38:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[48]);
	                		            int sortNum = Integer.parseInt(br.readLine());
	                		            switch(sortNum) {
	                		            	case 1:
	                		            		pw.println(user.getAllPapers());
	                		            		break;
	                		            	case 2:
	                		            		Comparator<ResearchPaper> citComparator = new CitationsComparator();
	                		            		pw.println(user.printPapers(citComparator));
	                		            		break;
	                		            	case 3:
	                		            		Comparator<ResearchPaper> dateComparator = new DateComparator();
	                		            		pw.println(user.printPapers(dateComparator));
	                		            		break;
	                		            	case 4:
	                		            		Comparator<ResearchPaper> pagesComparator = new PageComparator();
	                		            		pw.println(user.printPapers(pagesComparator));
	                		            		break;
	                		            }
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue stmenu;
	                		case 39:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[49]);  
	                		            String paperName = br.readLine();
		                		        int pages = Integer.parseInt(br.readLine());
		                		        Researcher author = (Researcher) user;
		                		        ResearchPaper resPaper = new ResearchPaper(0, paperName, author, dateFormat.parse(br.readLine()), pages, new ArrayList<>());
		                		        Data.getInstance().getResearchPapers().add(resPaper);
		                		        pw.println(language[50]);    
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue stmenu;
	                		case 40:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[51]);
	                		            String researchPaperName = br.readLine();                                       
	                		            ResearchPaper targetPaper = null;
	                		            List<ResearchPaper> researchPapers = Data.getInstance().getResearchPapers();
	                		            for (ResearchPaper paper : researchPapers) {
	                		                if (paper.getName().equals(researchPaperName)) {
	                		                    targetPaper = paper;
	                		                    break;
	                		                }
	                		            }
	                		            pw.println(language[65]);
                                        int opt = Integer.parseInt(br.readLine());
                                        if(opt == 1) {
                                        	pw.println(language[66]);
                                        	Citation c = new Citation(br.readLine(), 0, ((Researcher)user));
                                        	Data.getInstance().getCitations().add(c);
                                    		targetPaper.getUsedCitations().add(c);
                                        }else if(opt == 2) {
                                        	pw.println(language[67]);
                                    		int n = Integer.parseInt(br.readLine());
                                    		for(Citation cit: Data.getInstance().getCitations()) {
                                    			if(cit.getId() == n) {
                                    				targetPaper.getUsedCitations().add(cit);
                                    				targetPaper.countCitations();
                                    				break;
                                    				}
                                    		}
                                        }
                                        int r = targetPaper.getCitations();
                                        r++;
                                        targetPaper.setCitations(r);
                                        pw.println(language[52]);
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue stmenu;
	                		case 43:
	                            try {
	                                   if (user.isInterestedInResearch()) {
	                                    //enter the name of the journal and research paper
	                                    pw.println(language[62]);
	                                       String enteredJournalName = br.readLine();
	                                       String enteredPaperName = br.readLine();
	                                       Journal targetJournal = null;
	                                       ResearchPaper targetResPaper = null;
	                                    
	                                    for(Journal journal : Data.getInstance().getJournals()) {
	                                     if (journal.getName().equals(enteredJournalName)) {
	                                            targetJournal = journal;
	                                            break;
	                                        }
	                                    }
	                                    if(targetJournal != null) {
	                                     for(ResearchPaper resPaper : Data.getInstance().getResearchPapers()) {
	                                      if(resPaper.getName().equals(enteredPaperName)) {
	                                       targetResPaper = resPaper;
	                                       break;
	                                      }
	                                     }
	                                     if(targetResPaper != null) {
	                                      targetJournal.submitPaper(targetResPaper);
	                                      pw.println(language[63]); //res paper is added to the journal
	                                     } else {
	                                      pw.println(language[53]);//wrong res paper name
	                                     }
	                                     
	                                    } else {
	                                     pw.println(language[64]); //wrong journal name
	                                    }
	                                    
	                                   } else {
	                                       pw.println(language[47]);
	                                   }
	                               } catch (Exception e) {
	                                   pw.println(language[47]);
	                               }
	                               continue stmenu;

	                		default:
	                			pw.println(language[7]);
	                		}
	            		}

	            	}
	            	if(user instanceof Teacher) {
	            		teacherMenu: while(true) {
	            			pw.println(language[8]);
	            			pw.println(language[32]);
	            			pw.println(language[60]);
	            			pw.println(language[44]);
	            			pw.println(language[57]);
	            			int option = Integer.parseInt(br.readLine());
	            			switch(option) {
	            			case 1:
	            				printList(((Teacher)user).viewCourses());
	            				continue teacherMenu;
	            			case 2:
	            				pw.println(language[9]);
	            				pw.println(((Teacher)user).sendComplaint(Integer.parseInt(br.readLine()), Integer.parseInt(br.readLine()), br.readLine()));
	            				continue teacherMenu;
	            			case 3:
	            				pw.println(language[10]);
	            				pw.println(((Teacher)user).viewStudentsInfo(Integer.parseInt(br.readLine())));
	            				continue teacherMenu;
	            			case 4:
	            				pw.println(language[11]);
	            				pw.println(((Teacher)user).putMark(Integer.parseInt(br.readLine()), br.readLine(), br.readLine(), Double.parseDouble(br.readLine())));
	            				continue teacherMenu;
	            			case 5:
	            				pw.println(language[12]);
	            				pw.println(((Teacher)user).putAtt(Integer.parseInt(br.readLine()), br.readLine(), Integer.parseInt(br.readLine()), Double.parseDouble(br.readLine())));
	            				continue teacherMenu;
	            			case 6:
	            				pw.println(language[13]);
	            				pw.println(((Teacher)user).manageCourse(br.readLine(), br.readLine(), LessonFormat.valueOf(br.readLine())));
	            				continue teacherMenu;
	            			case 7:
	            				pw.println(language[14]);
	            				pw.println(((Teacher)user).sendRequest(br.readLine()));
	            				continue teacherMenu;
	            			case 8:
	            				break menu;
	            			case 21:
	            				pw.println(language[33]);
	            				pw.println(((Employee)user).sendMessage(br.readLine(), br.readLine(), br.readLine(), br.readLine()));
	            				continue teacherMenu;
	            			case 22:
	            				for(Message m: ((Employee)user).viewMessage()) {
	            					pw.println(m.getSender().getSurname() + " " + m.getContent());
	            				}
	            				continue teacherMenu;
	            			case 23:
	            				for(Message m: ((Employee)user).viewSentMessage()) {
	            					pw.println(m.getRecipient().getSurname() + " " + m.getContent());
	            				}
	            				continue teacherMenu;
	            			case 24:
	            				pw.println(language[34]);
	            				pw.println(((Employee)user).sendOrder(br.readLine()));
	            				continue teacherMenu;
	                		case 30:
	                			for(News n: user.viewNews()) {
	                				pw.println(n.getTopic() + "\n" + n.getContent() );
	                			}
	                			continue teacherMenu;
	                		case 35:
	                			user.setResearcher(true);
	                			pw.println(language[45]);
	                			continue teacherMenu;
	                		case 36:
	                			user.setResearcher(false);
	                			pw.println(language[46]);
	                			continue teacherMenu;
	                		case 37:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(((Researcher) user).calculateHindex());
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue teacherMenu;
	                		case 38:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[48]);
	                		            int sortNum = Integer.parseInt(br.readLine());
	                		            switch(sortNum) {
	                		            	case 1:
	                		            		pw.println(user.getAllPapers());
	                		            		break;
	                		            	case 2:
	                		            		Comparator<ResearchPaper> citComparator = new CitationsComparator();
	                		            		pw.println(user.printPapers(citComparator));
	                		            		break;
	                		            	case 3:
	                		            		Comparator<ResearchPaper> dateComparator = new DateComparator();
	                		            		pw.println(user.printPapers(dateComparator));
	                		            		break;
	                		            	case 4:
	                		            		Comparator<ResearchPaper> pagesComparator = new PageComparator();
	                		            		pw.println(user.printPapers(pagesComparator));
	                		            		break;
	                		            }
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue teacherMenu;
	                		case 39:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[49]);  
	                		            String paperName = br.readLine();
		                		        int pages = Integer.parseInt(br.readLine());
		                		        Researcher author = (Researcher) user;
		                		        ResearchPaper resPaper = new ResearchPaper(0, paperName, author, dateFormat.parse(br.readLine()), pages, new ArrayList<>());
		                		        Data.getInstance().getResearchPapers().add(resPaper);
		                		        pw.println(language[50]);    
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue teacherMenu;
	                		case 40:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[51]);
	                		            String researchPaperName = br.readLine();                                       
	                		            ResearchPaper targetPaper = null;
	                		            List<ResearchPaper> researchPapers = Data.getInstance().getResearchPapers();
	                		            for (ResearchPaper paper : researchPapers) {
	                		                if (paper.getName().equals(researchPaperName)) {
	                		                    targetPaper = paper;
	                		                    break;
	                		                }
	                		            }
	                		            pw.println(language[65]);
                                        int opt = Integer.parseInt(br.readLine());
                                        if(opt == 1) {
                                        	pw.println(language[66]);
                                        	Citation c = new Citation(br.readLine(), 0, ((Researcher)user));
                                        	Data.getInstance().getCitations().add(c);
                                    		targetPaper.getUsedCitations().add(c);
                                        }else if(opt == 2) {
                                        	pw.println(language[67]);
                                    		int n = Integer.parseInt(br.readLine());
                                    		for(Citation cit: Data.getInstance().getCitations()) {
                                    			if(cit.getId() == n) {
                                    				targetPaper.getUsedCitations().add(cit);
                                    				targetPaper.countCitations();
                                    				break;
                                    				}
                                    		}
                                        }
                                        int r = targetPaper.getCitations();
                                        r++;
                                        targetPaper.setCitations(r);
                                        pw.println(language[52]);
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue teacherMenu;
	                		case 41:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		        	if(user.calculateHindex() >= 3) {
	                		        		user.setSupervisor(true);
		    	                			pw.println(language[55]);
	                		        	}
	                		        	pw.println(language[58]);
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                			continue teacherMenu;
	                		case 42:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		        	if(user.calculateHindex() >= 3) {
	                		        		user.setSupervisor(false);
		    	                			pw.println(language[56]);
	                		        	}
	                		        	pw.println(language[58]);
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                			continue teacherMenu;
	                		case 43:
	                            try {
	                                   if (user.isInterestedInResearch()) {
	                                    //enter the name of the journal and research paper
	                                    pw.println(language[62]);
	                                       String enteredJournalName = br.readLine();
	                                       String enteredPaperName = br.readLine();
	                                       Journal targetJournal = null;
	                                       ResearchPaper targetResPaper = null;
	                                    
	                                    for(Journal journal : Data.getInstance().getJournals()) {
	                                     if (journal.getName().equals(enteredJournalName)) {
	                                            targetJournal = journal;
	                                            break;
	                                        }
	                                    }
	                                    if(targetJournal != null) {
	                                     for(ResearchPaper resPaper : Data.getInstance().getResearchPapers()) {
	                                      if(resPaper.getName().equals(enteredPaperName)) {
	                                       targetResPaper = resPaper;
	                                       break;
	                                      }
	                                     }
	                                     if(targetResPaper != null) {
	                                      targetJournal.submitPaper(targetResPaper);
	                                      pw.println(language[63]); //res paper is added to the journal
	                                     } else {
	                                      pw.println(language[53]);//wrong res paper name
	                                     }
	                                     
	                                    } else {
	                                     pw.println(language[64]); //wrong journal name
	                                    }
	                                    
	                                   } else {
	                                       pw.println(language[47]);
	                                   }
	                               } catch (Exception e) {
	                                   pw.println(language[47]);
	                               }
	                               continue teacherMenu;

	            			default:
	            				pw.println(language[7]);
	            			}
	            		}
	            	}
	            	if (user instanceof Manager) {  
	            		managerMenu: while(true) {
	            			pw.println(language[15]);
	            			pw.println(language[32]);
	            			pw.println(language[60]);
	            			pw.println(language[59]);
	            			pw.println(language[44]);
	            			int option = Integer.parseInt(br.readLine());
	            			switch(option) {
	            			case 1:
	            				for(Map.Entry<User, Course> entry: ((Manager)user).viewRequests().entrySet()){
	            					User u = entry.getKey();
	            					Course c = entry.getValue();
	            					pw.println(u.getSurname() +" " +  u.getRole() +" "+ c.getCourseName());
	            				}
	            				continue managerMenu;
	            			case 2:
	            				pw.println(language[16]);
	            				pw.println(((Manager)user).addCourseForRegistration(br.readLine(), br.readLine(), Integer.parseInt(br.readLine())));
	            				continue managerMenu;
	            			case 3:
	            				pw.println(((Manager)user).assignCourseToTeachers());
	            				continue managerMenu;
	            			case 4:
	            				pw.println(((Manager)user).createStatisticalReport());
	            				continue managerMenu;
	            			case 5:
	            				pw.println(language[17]);
	            				printList(((Manager)user).viewInfoAboutStudents(br.readLine()));
	            				continue managerMenu;
	            			case 6:
	            				pw.println(language[17]);
	            				printList(((Manager)user).viewInfoAboutTeachers(br.readLine()));
	            				continue managerMenu;
	            			case 7:
	            				pw.println(((Manager)user).assignCourseToStudents());
	            				continue managerMenu;
	            			case 8:
	            				pw.println(language[18]);
	            				pw.println(((Manager)user).addNews(br.readLine(), br.readLine()));
	            				continue managerMenu;
	            			case 9:
	            				pw.println(language[19]);
	            				pw.println(((Manager)user).deleteNews(br.readLine()));
	            				continue managerMenu;
	            			case 10:
	            				pw.println(((Manager)user).putRateOfTeachers());
	            				continue managerMenu;
	            			case 11:
	            				break menu;
	            			case 12:
	            				pw.println(language[36]);
	            				pw.println(((Manager)user).addLessonToCourse(br.readLine(), LessonType.valueOf(br.readLine()),LessonFormat.valueOf(br.readLine()) , dateFormat.parse(br.readLine()), WeekDay.valueOf(br.readLine()),  br.readLine()));
	            				continue managerMenu;
	            			case 21:
	            				pw.println(language[33]);
	            				pw.println(((Employee)user).sendMessage(br.readLine(), br.readLine(), br.readLine(), br.readLine()));
	            				continue managerMenu;
	            			case 22:
	            				for(Message m: ((Employee)user).viewMessage()) {
	            					pw.println(m.getSender().getSurname() + " " + m.getContent());
	            				}
	            				continue managerMenu;
	            			case 23:
	            				for(Message m: ((Employee)user).viewSentMessage()) {
	            					pw.println(m.getRecipient().getSurname() + " " + m.getContent());
	            				}
	            				continue managerMenu;
	            			case 24:
	            				pw.println(language[34]);
	            				pw.println(((Employee)user).sendOrder(br.readLine()));
	            				continue managerMenu;
	                		case 30:
	                			for(News n: user.viewNews()) {
	                				pw.println(n.getTopic() + "\n" + n.getContent() );
	                			}
	                			continue managerMenu;
	                		case 31: 
	            				pw.println(language[37]);
	            			    ((Manager)user).createJournal(br.readLine());
	            			    pw.println(language[38]);
	            			    continue managerMenu;
	            			case 32:
	            				pw.println(language[37]);
	            				((Manager)user).deleteJournal(br.readLine());
	            				pw.println(language[39]);
	            				continue managerMenu;
	            			case 35:
	                			user.setResearcher(true);
	                			pw.println(language[45]);
	                			continue managerMenu;
	                		case 36:
	                			user.setResearcher(false);
	                			pw.println(language[46]);
	                			continue managerMenu;
	                		case 37:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(((Researcher) user).calculateHindex());
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue managerMenu;
	                		case 38:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[48]);
	                		            int sortNum = Integer.parseInt(br.readLine());
	                		            switch(sortNum) {
	                		            	case 1:
	                		            		pw.println(user.getAllPapers());
	                		            		break;
	                		            	case 2:
	                		            		Comparator<ResearchPaper> citComparator = new CitationsComparator();
	                		            		pw.println(user.printPapers(citComparator));
	                		            		break;
	                		            	case 3:
	                		            		Comparator<ResearchPaper> dateComparator = new DateComparator();
	                		            		pw.println(user.printPapers(dateComparator));
	                		            		break;
	                		            	case 4:
	                		            		Comparator<ResearchPaper> pagesComparator = new PageComparator();
	                		            		pw.println(user.printPapers(pagesComparator));
	                		            		break;
	                		            }
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue managerMenu;
	                		case 39:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[49]);  
	                		            String paperName = br.readLine();
		                		        int pages = Integer.parseInt(br.readLine());
		                		        Researcher author = (Researcher) user;
		                		        ResearchPaper resPaper = new ResearchPaper(0, paperName, author, dateFormat.parse(br.readLine()), pages, new ArrayList<>());
		                		        Data.getInstance().getResearchPapers().add(resPaper);
		                		        pw.println(language[50]);    
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue managerMenu;
	                		case 40:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[51]);
	                		            String researchPaperName = br.readLine();                                       
	                		            ResearchPaper targetPaper = null;
	                		            List<ResearchPaper> researchPapers = Data.getInstance().getResearchPapers();
	                		            for (ResearchPaper paper : researchPapers) {
	                		                if (paper.getName().equals(researchPaperName)) {
	                		                    targetPaper = paper;
	                		                    break;
	                		                }
	                		            }
	                		            pw.println(language[65]);
                                        int opt = Integer.parseInt(br.readLine());
                                        if(opt == 1) {
                                        	pw.println(language[66]);
                                        	Citation c = new Citation(br.readLine(), 0, ((Researcher)user));
                                        	Data.getInstance().getCitations().add(c);
                                    		targetPaper.getUsedCitations().add(c);
                                        }else if(opt == 2) {
                                        	pw.println(language[67]);
                                    		int n = Integer.parseInt(br.readLine());
                                    		for(Citation cit: Data.getInstance().getCitations()) {
                                    			if(cit.getId() == n) {
                                    				targetPaper.getUsedCitations().add(cit);
                                    				targetPaper.countCitations();
                                    				break;
                                    				}
                                    		}
                                        }
                                        int r = targetPaper.getCitations();
                                        r++;
                                        targetPaper.setCitations(r);
                                        pw.println(language[52]);
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue managerMenu;
	                		case 43:
	                            try {
	                                   if (user.isInterestedInResearch()) {
	                                    //enter the name of the journal and research paper
	                                    pw.println(language[62]);
	                                       String enteredJournalName = br.readLine();
	                                       String enteredPaperName = br.readLine();
	                                       Journal targetJournal = null;
	                                       ResearchPaper targetResPaper = null;
	                                    
	                                    for(Journal journal : Data.getInstance().getJournals()) {
	                                     if (journal.getName().equals(enteredJournalName)) {
	                                            targetJournal = journal;
	                                            break;
	                                        }
	                                    }
	                                    if(targetJournal != null) {
	                                     for(ResearchPaper resPaper : Data.getInstance().getResearchPapers()) {
	                                      if(resPaper.getName().equals(enteredPaperName)) {
	                                       targetResPaper = resPaper;
	                                       break;
	                                      }
	                                     }
	                                     if(targetResPaper != null) {
	                                      targetJournal.submitPaper(targetResPaper);
	                                      pw.println(language[63]); //res paper is added to the journal
	                                     } else {
	                                      pw.println(language[53]);//wrong res paper name
	                                     }
	                                     
	                                    } else {
	                                     pw.println(language[64]); //wrong journal name
	                                    }
	                                    
	                                   } else {
	                                       pw.println(language[47]);
	                                   }
	                               } catch (Exception e) {
	                                   pw.println(language[47]);
	                               }
	                               continue managerMenu;

	            			default:
	            				pw.println(language[7]);
	            			}
	            			
	            		}
	            	}
	            	if(user instanceof Admin) {
	            		adminMenu: while(true) {
	            			pw.println(language[20]);
	            			pw.println(language[32]);
	            			pw.println(language[60]);
	            			pw.println(language[59]);
	            			int option = Integer.parseInt(br.readLine());
	            			switch(option) {
	            			case 1:
	            				pw.println(language[21]);
	            				pw.println(((Admin)user).addStudent(br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine()));
	            				continue adminMenu;
	            			case 2:
	            				pw.println(language[22]);
	            				pw.println(((Admin)user).addTeacher(br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine()), br.readLine()));
	            				continue adminMenu;
	            			case 3:
	            				pw.println(language[23]);
	            				pw.println(((Admin)user).addManager( br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine())));
	            				continue adminMenu;
	            			case 4:
	            				pw.println(language[24]);
	            				pw.println(((Admin)user).addDean( br.readLine() , br.readLine(), br.readLine(),br.readLine(), br.readLine(),br.readLine(), Integer.parseInt(br.readLine())));
	            				continue adminMenu;
	            			case 5:
	            				pw.println(language[25]);
	            				pw.println(((Admin)user).addTechSupport( br.readLine(), br.readLine(), br.readLine(), br.readLine(), br.readLine(), Integer.parseInt(br.readLine())));
	            				continue adminMenu;
	            			case 6:
	            				pw.println(language[26]);
	            				pw.println(((Admin)user).removeUser(Integer.parseInt(br.readLine())));
	            				continue adminMenu;
	            			case 7:
	            				pw.println(language[27]);
	            				pw.println(((Admin)user).updateUser(Integer.parseInt(br.readLine()),br.readLine(), br.readLine()));
	            				continue adminMenu;
	            			case 8:
	            				for(User u :(((Admin)user).seeLogFiles(user))) {
	            					pw.println(u.getId() + ") " +  u.getUsername() + " " + u.getPassword());
	            				}
	            				continue adminMenu;
	            			case 9:
	            				break menu;
	            			case 21:
	            				pw.println(language[33]);
	            				pw.println(((Employee)user).sendMessage(br.readLine(), br.readLine(), br.readLine(), br.readLine()));
	            				continue adminMenu;
	            			case 22:
	            				for(Message m: ((Employee)user).viewMessage()) {
	            					pw.println(m.getSender().getSurname() + " " + m.getContent());
	            				}
	            				continue adminMenu;
	            			case 23:
	            				for(Message m: ((Employee)user).viewSentMessage()) {
	            					pw.println(m.getRecipient().getSurname() + " " + m.getContent());
	            				}
	            				continue adminMenu;
	            			case 24:
	            				pw.println(language[34]);
	            				pw.println(((Employee)user).sendOrder(br.readLine()));
	            				continue adminMenu;
	                		case 30:
	                			for(News n: user.viewNews()) {
	                				pw.println(n.getTopic() + "\n" + n.getContent() );
	                			}
	                			continue adminMenu;
	                		case 31: 
	            				pw.println(language[37]);
	            			    ((Manager)user).createJournal(br.readLine());
	            			    pw.println(language[38]);
	            			    continue adminMenu;
	            			case 32:
	            				pw.println(language[37]);
	            				((Manager)user).deleteJournal(br.readLine());
	            				pw.println(language[39]);
	            				continue adminMenu;
	            			default:
	            				pw.println(language[7]);
	            			}
	            			
	            		}
	            	}
	            	if(user instanceof Dean) {
	            		deanMenu: while(true) {
	            			pw.println(language[28]);
	            			pw.println(language[32]);
	            			pw.println(language[60]);
	            			pw.println(language[44]);
	            			int option = Integer.parseInt(br.readLine());
	            			switch(option) {
	            			case 1:
	            				printList(((Dean)user).viewComplaint());
	            				continue deanMenu;
	            			case 2:
	            				break menu;
	            			case 21:
	            				pw.println(language[33]);
	            				pw.println(((Employee)user).sendMessage(br.readLine(), br.readLine(), br.readLine(), br.readLine()));
	            				continue deanMenu;
	            			case 22:
	            				for(Message m: ((Employee)user).viewMessage()) {
	            					pw.println(m.getSender().getSurname() + " " + m.getContent());
	            				}
	            				continue deanMenu;
	            			case 23:
	            				for(Message m: ((Employee)user).viewSentMessage()) {
	            					pw.println(m.getRecipient().getSurname() + " " + m.getContent());
	            				}
	            				continue deanMenu;
	            			case 24:
	            				pw.println(language[34]);
	            				pw.println(((Employee)user).sendOrder(br.readLine()));
	            				continue deanMenu;
	                		case 30:
	                			for(News n: user.viewNews()) {
	                				pw.println(n.getTopic() + "\n" + n.getContent() );
	                			}
	                			continue deanMenu;
	                		case 35:
	                			user.setResearcher(true);
	                			pw.println(language[45]);
	                			continue deanMenu;
	                		case 36:
	                			user.setResearcher(false);
	                			pw.println(language[46]);
	                			continue deanMenu;
	                		case 37:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(((Researcher) user).calculateHindex());
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue deanMenu;
	                		case 38:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[48]);
	                		            int sortNum = Integer.parseInt(br.readLine());
	                		            switch(sortNum) {
	                		            	case 1:
	                		            		pw.println(user.getAllPapers());
	                		            		break;
	                		            	case 2:
	                		            		Comparator<ResearchPaper> citComparator = new CitationsComparator();
	                		            		pw.println(user.printPapers(citComparator));
	                		            		break;
	                		            	case 3:
	                		            		Comparator<ResearchPaper> dateComparator = new DateComparator();
	                		            		pw.println(user.printPapers(dateComparator));
	                		            		break;
	                		            	case 4:
	                		            		Comparator<ResearchPaper> pagesComparator = new PageComparator();
	                		            		pw.println(user.printPapers(pagesComparator));
	                		            		break;
	                		            }
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue deanMenu;
	                		case 39:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[49]);  
	                		            String paperName = br.readLine();
		                		        int pages = Integer.parseInt(br.readLine());
		                		        Researcher author = (Researcher) user;
		                		        ResearchPaper resPaper = new ResearchPaper(0, paperName, author, dateFormat.parse(br.readLine()), pages, new ArrayList<>());
		                		        Data.getInstance().getResearchPapers().add(resPaper);
		                		        pw.println(language[50]);    
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue deanMenu;
	                		case 40:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[51]);
	                		            String researchPaperName = br.readLine();                                       
	                		            ResearchPaper targetPaper = null;
	                		            List<ResearchPaper> researchPapers = Data.getInstance().getResearchPapers();
	                		            for (ResearchPaper paper : researchPapers) {
	                		                if (paper.getName().equals(researchPaperName)) {
	                		                    targetPaper = paper;
	                		                    break;
	                		                }
	                		            }
	                		            pw.println(language[65]);
                                        int opt = Integer.parseInt(br.readLine());
                                        if(opt == 1) {
                                        	Citation c = new Citation(br.readLine(), 0, ((Researcher)user));
                                        	Data.getInstance().getCitations().add(c);
                                    		targetPaper.getUsedCitations().add(c);
                                        }else if(opt == 2) {
                                        	pw.println(language[67]);
                                    		int n = Integer.parseInt(br.readLine());
                                    		for(Citation cit: Data.getInstance().getCitations()) {
                                    			if(cit.getId() == n) {
                                    				targetPaper.getUsedCitations().add(cit);
                                    				targetPaper.countCitations();
                                    				break;
                                    				}
                                    		}
                                        }
                                        int r = targetPaper.getCitations();
                                        r++;
                                        targetPaper.setCitations(r);
                                        pw.println(language[52]);
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue deanMenu;
	                		case 43:
	                            try {
	                                   if (user.isInterestedInResearch()) {
	                                    //enter the name of the journal and research paper
	                                    pw.println(language[62]);
	                                       String enteredJournalName = br.readLine();
	                                       String enteredPaperName = br.readLine();
	                                       Journal targetJournal = null;
	                                       ResearchPaper targetResPaper = null;
	                                    
	                                    for(Journal journal : Data.getInstance().getJournals()) {
	                                     if (journal.getName().equals(enteredJournalName)) {
	                                            targetJournal = journal;
	                                            break;
	                                        }
	                                    }
	                                    if(targetJournal != null) {
	                                     for(ResearchPaper resPaper : Data.getInstance().getResearchPapers()) {
	                                      if(resPaper.getName().equals(enteredPaperName)) {
	                                       targetResPaper = resPaper;
	                                       break;
	                                      }
	                                     }
	                                     if(targetResPaper != null) {
	                                      targetJournal.submitPaper(targetResPaper);
	                                      pw.println(language[63]); //res paper is added to the journal
	                                     } else {
	                                      pw.println(language[53]);//wrong res paper name
	                                     }
	                                     
	                                    } else {
	                                     pw.println(language[64]); //wrong journal name
	                                    }
	                                    
	                                   } else {
	                                       pw.println(language[47]);
	                                   }
	                               } catch (Exception e) {
	                                   pw.println(language[47]);
	                               }
	                               continue deanMenu;

	            			 default:
	            				 pw.println(language[7]);
	            			}		
	            		}
	            	}
	            	if(user instanceof TechSupporter) {
	            		tsmenu: while(true) {
	            			pw.println(language[29]);
	            			pw.println(language[35]);
	            			pw.println(language[60]);
	            			pw.println(language[44]);
	            			int option = Integer.parseInt(br.readLine());
	            			switch(option) {
	            			case 1:
	            				for(Order o: ((TechSupporter)user).seeOrders()) {
	            					pw.println(o.toString());
	            				}
	            				continue tsmenu;
	            			case 2:
	            				pw.println(language[30]);
	            				pw.println(((TechSupporter)user).acceptOrder(Integer.parseInt(br.readLine())));
	            				continue tsmenu;
	            			case 3:
	            				pw.println(language[31]);
	            				pw.println(((TechSupporter)user).rejectOrder(Integer.parseInt(br.readLine())));
	            				continue tsmenu;
	            			case 4:
	            				break menu;
	            			case 21:
	            				pw.println(language[33]);
	            				pw.println(((Employee)user).sendMessage(br.readLine(), br.readLine(), br.readLine(), br.readLine()));
	            				continue tsmenu;
	            			case 22:
	            				for(Message m: ((Employee)user).viewMessage()) {
	            					pw.println(m.getSender().getSurname() + " " + m.getContent());
	            				}
	            				continue tsmenu;
	            			case 23:
	            				for(Message m: ((Employee)user).viewSentMessage()) {
	            					pw.println(m.getRecipient().getSurname() + " " + m.getContent());
	            				}
	            				continue tsmenu;
	                		case 30:
	                			for(News n: user.viewNews()) {
	                				pw.println(n.getTopic() + "\n" + n.getContent() );
	                			}
	                			continue tsmenu;
	                		case 35:
	                			user.setResearcher(true);
	                			pw.println(language[45]);
	                			continue tsmenu;
	                		case 36:
	                			user.setResearcher(false);
	                			pw.println(language[46]);
	                			continue tsmenu;
	                		case 37:
	                			try {
	                		        if (user instanceof Researcher) {
	                		            pw.println(((Researcher) user).calculateHindex());
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue tsmenu;
	                		case 38:
	                			try {
	                		        if (user instanceof Researcher) {
	                		            pw.println(language[48]);
	                		            int sortNum = Integer.parseInt(br.readLine());
	                		            switch(sortNum) {
	                		            	case 1:
	                		            		pw.println(user.getAllPapers());
	                		            		break;
	                		            	case 2:
	                		            		Comparator<ResearchPaper> citComparator = new CitationsComparator();
	                		            		pw.println(user.printPapers(citComparator));
	                		            		break;
	                		            	case 3:
	                		            		Comparator<ResearchPaper> dateComparator = new DateComparator();
	                		            		pw.println(user.printPapers(dateComparator));
	                		            		break;
	                		            	case 4:
	                		            		Comparator<ResearchPaper> pagesComparator = new PageComparator();
	                		            		pw.println(user.printPapers(pagesComparator));
	                		            		break;
	                		            }
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue tsmenu;
	                		case 39:
	                			try {
	                		        if (user.isInterestedInResearch()) {
	                		            pw.println(language[49]);  
	                		            String paperName = br.readLine();
		                		        int pages = Integer.parseInt(br.readLine());
		                		        Researcher author = (Researcher) user;
		                		        ResearchPaper resPaper = new ResearchPaper(0, paperName, author, dateFormat.parse(br.readLine()), pages, new ArrayList<>());
		                		        Data.getInstance().getResearchPapers().add(resPaper);
		                		        pw.println(language[50]);    
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue tsmenu;
	                		case 40:
	                			try {
	                		        if (user instanceof Researcher) {
	                		            pw.println(language[51]);
	                		            String researchPaperName = br.readLine();                                       
	                		            ResearchPaper targetPaper = null;
	                		            List<ResearchPaper> researchPapers = Data.getInstance().getResearchPapers();
	                		            for (ResearchPaper paper : researchPapers) {
	                		                if (paper.getName().equals(researchPaperName)) {
	                		                    targetPaper = paper;
	                		                    break;
	                		                }
	                		            }
	                		            pw.println(language[65]);
                                        int opt = Integer.parseInt(br.readLine());
                                        if(opt == 1) {
                                        	Citation c = new Citation(br.readLine(), 0, ((Researcher)user));
                                        	Data.getInstance().getCitations().add(c);
                                    		targetPaper.getUsedCitations().add(c);
                                        }else if(opt == 2) {
                                        	pw.println(language[67]);
                                    		int n = Integer.parseInt(br.readLine());
                                    		for(Citation cit: Data.getInstance().getCitations()) {
                                    			if(cit.getId() == n) {
                                    				targetPaper.getUsedCitations().add(cit);
                                    				targetPaper.countCitations();
                                    				break;
                                    				}
                                    		}
                                        }
                                        int r = targetPaper.getCitations();
                                        r++;
                                        targetPaper.setCitations(r);
                                        pw.println(language[52]);
	                		        } else {
	                		            pw.println(language[47]);
	                		        }
	                		    } catch (Exception e) {
	                		        pw.println(language[47]);
	                		    }
	                		    continue tsmenu;
	                		case 43:
	                            try {
	                                   if (user instanceof Researcher) {
	                                    //enter the name of the journal and research paper
	                                    pw.println(language[62]);
	                                       String enteredJournalName = br.readLine();
	                                       String enteredPaperName = br.readLine();
	                                       Journal targetJournal = null;
	                                       ResearchPaper targetResPaper = null;
	                                    
	                                    for(Journal journal : Data.getInstance().getJournals()) {
	                                     if (journal.getName().equals(enteredJournalName)) {
	                                            targetJournal = journal;
	                                            break;
	                                        }
	                                    }
	                                    if(targetJournal != null) {
	                                     for(ResearchPaper resPaper : Data.getInstance().getResearchPapers()) {
	                                      if(resPaper.getName().equals(enteredPaperName)) {
	                                       targetResPaper = resPaper;
	                                       break;
	                                      }
	                                     }
	                                     if(targetResPaper != null) {
	                                      targetJournal.submitPaper(targetResPaper);
	                                      pw.println(language[63]); //res paper is added to the journal
	                                     } else {
	                                      pw.println(language[53]);//wrong res paper name
	                                     }
	                                     
	                                    } else {
	                                     pw.println(language[64]); //wrong journal name
	                                    }
	                                    
	                                   } else {
	                                       pw.println(language[47]);
	                                   }
	                               } catch (Exception e) {
	                                   pw.println(language[47]);
	                               }
	                               continue tsmenu;
	            			 default:
	            				 pw.println(language[7]);
	            			}
	            		}
	            	}
	            }else {
	            	pw.println(language[1]);
	            	continue menu;
	            }
	        }
		}
		catch (Exception e) {
            e.printStackTrace(); 
            Data.getInstance().saveToFile("a.ser");
        } finally {
        	Data.getInstance().saveToFile("a.ser");
            try {
                br.close();
                pw.close();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
    private static final String[] EnglishLanguage = {
    		"Enter username and password ", "Wrong credentials try again",
    		"1) View courses\n2) View Teacher Info\n3) View Marks\n"
    		+ "4) View transcript\n5) Join to student organization\n6) Send request for course\n7) Rate teacher\n8) Create student organization"
    		+ "\n9) View attestation\n10) Exit  \n33) Subscribe to the Journal \n34) Unsubscribe from the Journal" ,
    		"Enter course name and lessons code to know the grade: ",
    		"Enter organization name that you want to join: ",
    		"Enter course name that you want to take: ",
    		"Enter teacher name and your grade to this teacher: ",
    		"There is no other choices!",
    		"1) View courses\n2) Send complaint\n3) View student info\n4) Put mark\n5) Put attestation\n6) Manage course\n7) "
    		+ "Send request for course\n8) Exit", 
    		"Enter the urgency level from 1 to 3, then id of student, then content of complaint",
    		"Enter id of student",
    		"Enter id of student, then course name , then lesson code, then grade of this student in this lesson",
    		"Enter id of student, then course name,\n then if first att enter 1 and 0 if second enter 2 and 0 if final enter 3"
    		+ "and grade for final",
    		"Enter course name, then lesson code, then format(ONLINE, OFFLINE) that you need to change",
    		"Enter course name that you want to teach",
    		"1) View requests\n2) Add Course for registrattion\n3) Assign courses to teachers\n"
    		+ "4) Create statistical report\n5) View info about students\n6) View info about teacher\n"
    		+ "7) Assign course to students\n8) Add news\n9) Delete news\n10) Update rate of teachers"
    		+ "\n11) Exit\n12) Add lesson to course", "Enter course code, course name and course credits",
    		"Enter the order(Name, Surname, ID)", "Enter the topic(if it is research new it must "
    				+ "contain word Research), and content", "Enter the topic of news that you want"
    						+ " to delete", "1) Add student\n2) Add teacher\n3) Add manager"
    								+ "\n4) Add dean\n5) Add techsupporter\n6) Remove user\n7) Update user\n8) See "
    								+ "log files\n9) Exit",
    		"Enter the username, password, name, surname, gender(MALE, FEMALE), faculty, major of the student line by line",
    		"Enter the username, password, name, surname, gender(MALE, FEMALE), faculty, salary and title of the teacher",
    		"Enter the username, password, name, surname, gender(MALE, FEMALE), faculty, salary of the manager",
    		"Enter the username, password, name, surname, gender(MALE, FEMALE), faculty, salary of the dean",
    		"Enter the username, password, name, surname, gender(MALE, FEMALE), salary of the techsupporter",
    		"Enter the user id that you want to remove","Enter the id , new password and new username of the user that "
    		+ "you want to update","1) View complaints\n2) Exit",
    		"1) See orders\n2) Accept order\n3) Reject order\n4) Exit", "Enter the id of order that you want to accept",
    		"Enter the id of order that you want to reject", "21) Send message\n22) View message\n23) View sent message\n24) Send order",
    		"Enter the name, surname, role of the recipient and your message line by line", "Enter the description of order",
    		"21) Send message\n22) View message\n23) View sent message","Enter course name, Lesson type(LECTURE, PRACTISE, LAB), format(ONLINE, OFFLINE), date(dd.MM.yyyy), day(MONDAY....),"
    		+ " and lessons code", "Enter the name of the Journal:", "New Journal created successfully!",
    		"Journal deleted successfully!", "You subscribed to the Journal!", "You unsubscribed from the Journal!", 
    		"You are not subscribed for this journal!", "Journal was not found.", "35) Become a Researcher \n36) Leave from the Research \n37) Show h-index \n38) Display your research papers \n39) Add research paper \n40) Add citations to the research paper\n"
    				+ "43) Add research paper to the journal.",
    		"You have become researcher!", "Now you are not a researcher.", "Error! You are not a researcher!", "Choose option to sort: \n1)No sort \n2)Sort by citations \n3)Sort by date \n4)Sort by pages",
    		"Enter the name for research paper,  pages, Date (dd.MM.yyyy)", "Research paper added successfully!", "Enter the name of research paper", "Citation is added",
    		"Research paper not found with the given name.", "Enter the content of citation, how many time it was used", "You have become supervisor!", "Now you are not a supervisor.", "41) Become supervisor \n42) Not supervisor",
    		"H-index is less than 3.", "31) Create Journal \n32) Delete Journal" ,"30) View News", "Enter the name of St Org that you want to create", 
    		"Enter the journal name, research paper name", "Research paper is added to the journal!", "Wrong journal name!","1) New citation\n2) Use someones citation", "Enter the content of citation", "Enter the id of someones citation that you wanted to use:",
        };

        private static final String[] KazakhLanguage = {
        		"Пайдаланушы аты мен құпия сөзді енгізіңіз", "қате тіркелгі деректерімен әрекетті қайталаңыз",
        		"1) курстарды қараңыз\n2) оқытушы туралы ақпаратты қараңыз\n3) бағаларды қараңыз\n"
        		+ "4) транскрипцияны қараңыз\n5) студенттер ұйымына қосылыңыз\n6) курсқа сұраныс жіберіңіз\n7) оқытушыны бағалаңыз\n8) студенттер ұйымын құрыңыз"
        		+ "\n9) Аттестацияны қарау\n10) Шығу \n33) Журналға жазылу \n34) Журналға жазылудан бас тарту" ,
        		"Бағаны білу үшін курстың атын және сабақ кодын енгізіңіз:",
        		"Қосылғыңыз келетін ұйымның атын енгізіңіз:",
        		"Аяқтағыңыз келетін курстың атын енгізіңіз:",
        		"Оқытушының атын және осы оқытушыға бағаңызды енгізіңіз:",
        		"Басқа нұсқалар жоқ!",
        		"1) курстарды қарау\n2) шағым жіберу\n3) студент туралы ақпаратты қарау\n4) белгі қою\n5) аттестаттауды қою\n6) курсты басқару\n7)"
        		+ "Курсты аяқтауға сұраныс жіберу\n8)",
        		"1-ден 3-ке дейінгі жеделдік деңгейін, содан кейін студенттің идентификаторын, содан кейін шағымның мазмұнын енгізіңіз",
        		"Студент идентификаторын енгізіңіз",
        		"Студенттің идентификаторын, содан кейін курстың атын, содан кейін сабақ кодын, содан кейін сол студенттің бағасын осы сабаққа енгізіңіз",
        		"Студент идентификаторын, содан кейін курс атауын енгізіңіз,\n содан кейін, егер бірінші att болса, 1 және 0 теріңіз, егер екінші болса, 2 және 0 теріңіз, егер соңғы болса, 3 /n теріңіз "
        		+ "және қорытынды баға",
        		"Курстың атын, содан кейін сабақ кодын, содан кейін өзгерту қажет форматты (ОНЛАЙН, офлайн) енгізіңіз",
        		"Оқытқыңыз келетін курстың атын енгізіңіз",
        		"1) сұрауларды қарау\n2) тіркеу үшін курсты қосу\n3) мұғалім курстарын тағайындау\n"
        		+ "4) статистикалық есеп жасаңыз\n5)студенттер туралы ақпаратты қараңыз\n6) оқытушы туралы ақпаратты қараңыз\n"
        		+ "7) студенттерге курсты тағайындау\n8) жаңалықтар қосу\n9) жаңалықтарды жою\n10) мұғалімдердің жаңару жиілігі"
        		+ "\n11) шығу\n12) курсқа сабақ қосыңыз", "курс кодын, курс атауын және курстың кредиттік бірліктерін енгізіңіз",
        		"Тапсырысты енгізіңіз (аты, тегі, идентификаторы)", " тақырыпты енгізіңіз (егер бұл зерттеу Жаңа болса, ол болуы керек "
        		+ "Research сөзін қамтиды) және мазмұн","өзіңіз қалаған жаңалықтар тақырыбын енгізіңіз"
        		+ "жою", "1) студент қосу\n2) мұғалім қосу\n3) менеджер қосу"
        		+ "\n4) декан қосу\n5 )техникалық қолдау қосу\n6) пайдаланушыны жою\n7) пайдаланушыны жаңарту\n8) көру"
        		+ "журнал файлдары\n9) шығу",
        		"Пайдаланушы атын, парольді, атын, тегін, жынысын (еркек, әйел), факультетін, студенттің мамандығын жол бойынша енгізіңіз",
        		"Пайдаланушы атын, парольді, атын, тегін, жынысын (ерлер, әйелдер), факультетін, жалақысын және оқытушылық лауазымын енгізіңіз",
        		"Пайдаланушы атын, парольді, атын, тегін, жынысын (еркек, әйел), факультетін, менеджердің жалақысын енгізіңіз",
        		"Пайдаланушы атын, парольді, атын, тегін, жынысын(еркек, әйел), факультетін, деканның жалақысын енгізіңіз",
        		"Пайдаланушы атын, құпия сөзді, атын, тегін, жынысын (ер, әйел), техникалық қызметкердің жалақысын енгізіңіз",
        		"Жойғыңыз келетін пайдаланушы идентификаторын енгізіңіз", " идентификаторды, жаңа құпия сөзді және жаңа пайдаланушы атын енгізіңіз "
        		+ "сіз жаңартқыңыз келеді", "1) шағымдарды қарау\n2) шығу",
        		"1) тапсырыстарды қарау\n2) тапсырысты қабылдау\n3) тапсырысты қабылдамау\n4) шығу", "қабылдағыңыз келетін тапсырыс идентификаторын енгізіңіз",
        		"Бас тартқыңыз келетін тапсырыс идентификаторын енгізіңіз", "21) хабарлама жіберу\n22) хабарламаны көру\n23) жіберілген хабарламаны көру\n24) тапсырысты жіберу",
        		"Алушының атын, тегін, рөлін және хабарламаңызды жол-жолға енгізіңіз", "Тапсырыс сипаттамасын енгізіңіз",
        		"21) хабарлама жіберу\n22) хабарламаны қарау\n23) жіберілген хабарламаны қарау","курстың атауын, сабақ түрін (дәріс, ПРАКТИКА, зертханалық жұмыс), форматты (ОНЛАЙН, офлайн), күнді (кк.ММ. ЖЖЖЖ), күн (дүйсенбі....),"
        		+ "және сабақ коды", " журналдың атын енгізіңіз:", " жаңа журнал сәтті жасалды!",
        		"Журнал сәтті жойылды!", "Сіз журналға жазылдыңыз!", "Сіз журналдан бас тарттыңыз!",
        		"Сіз бұл журналға жазылмайсыз!", "Журнал табылмады.", "35) зерттеуші болыңыз \n36) зерттеуден шығыңыз \n37) h индексін көрсетіңіз \n38) зерттеу жұмысыңызды көрсетіңіз \n39) зерттеу жұмысын қосыңыз \n40) зерттеу жұмысына дәйексөз қосыңыз\n"
        		+ "43) журналға зерттеу жұмысын қосыңыз.",
        		"Сіз зерттеуші болдыңыз!", "Енді сіз зерттеуші емессіз.", "Қате! Сіз зерттеуші емессіз!", "Сұрыптау опциясын таңдаңыз:\n1) сұрыптау жоқ \n2) дәйексөз бойынша сұрыптау \n3) күні бойынша сұрыптау \n4) беттер бойынша сұрыптау",
        		"Зерттеу жұмысының атауын, беттерін, күнін енгізіңіз (dd.ММ. ЖЖЖЖ)", " зерттеу жұмысы сәтті қосылды!", "Зерттеу жұмысының атауын енгізіңіз", "дәйексөз қосылды",
        		"Аталған атаумен зерттеу жұмысы табылған жоқ.", "Мазмұнын енгізіңіз дәйексөз, ол қанша рет қолданылған", " Сіз супервайзер болдыңыз!", "Енді сіз супервайзер емессіз.", "41) супервайзер болу \n42) супервайзер емес",
        		"Хирш индексі 3-тен аз.", "31) журнал жасау\n32) журналды жою", "30) жаңалықтарды қарау", "жасағыңыз келетін ұйымның атын енгізіңіз",
        		"Журналдың атын, ғылыми мақаланың атауын енгізіңіз", " зерттеу мақаласы журналға қосылды!", "Журналдың дұрыс емес атауы!", "1) Жаңа дәйексөз\n2) біреудің дәйексөзін қолданыңыз", "дәйексөздің мазмұнын енгізіңіз","пайдаланғыңыз келген біреудің дәйексөзінің идентификаторын енгізіңіз:",

        };

        private static final String[] RussianLanguage = {
        		"Введите имя пользователя и пароль", "Повторите попытку с неверными учетными данными",
        		"1) Просмотрите курсы\n2) Просмотрите информацию о преподавателе\n3) Просмотрите оценки\n"
        		+ "4) Просмотрите расшифровку\n5) Присоединяйтесь к студенческой организации\n6) Отправьте запрос на курс\n7) Оцените преподавателя\n8) Создайте студенческую организацию"
        		+ "\n9) Просмотреть аттестацию\n10) Выйти \n33) Подписаться на журнал \n34) Отказаться от подписки на журнал" ,
        		"Введите название курса и код урока, чтобы узнать оценку: ",
        		"Введите название организации, к которой вы хотите присоединиться: ",
        		"Введите название курса, который вы хотите пройти: ",
        		"Введите имя преподавателя и вашу оценку этому преподавателю: ",
        		"Других вариантов нет!",
        		"1) Просмотреть курсы\n2) Отправить жалобу\n3) Просмотреть информацию о студенте\n4) Поставьте отметку\n5) Поставить аттестацию\n6) Управлять курсом\n7) "
        		+ "Отправить запрос на завершение курса\n8)",
        		"Введите уровень срочности от 1 до 3, затем идентификатор студента, затем содержание жалобы",
        		"Введите идентификатор студента",
        		"Введите идентификатор студента, затем название курса, затем код урока, затем оценку этого студента в этот урок",
        		"Введите идентификатор студента, затем название курса,\n затем, если первый att, введите 1 и 0, если второй, введите 2 и 0, если окончательный, введите 3 /n "
        		+ "и итоговая оценка",
        		"Введите название курса, затем код урока, затем формат (ОНЛАЙН, ОФФЛАЙН), который вам нужно изменить",
        		"Введите название курса, который вы хотите преподавать",
        		"1) Просмотр запросов\n2) Добавление курса для регистрации\n3) Назначение курсов учителя\n"
        		+ "4) Создать статистический отчет\n5) Просмотреть информацию о студентах\n6) Просмотреть информацию о преподавателе\n"
        		+ "7) Назначить курс студентам\n8) Добавить новости\n9) Удалить новости\n10) Частота обновления преподавателей"
        		+ "\n11) Выход\n12) Добавить урок в курс", "Введите код курса, название курса и зачетные единицы курса",
        		"Введите порядок (Имя, фамилия, идентификатор)", "Введите тему (если это исследование новое, оно должно быть "
        		+ "содержит слово Research) и контент", "Введите тему новости, которую вы хотите"
        		+ "удалить", "1) Добавить студента\n2) Добавить преподавателя\n3) Добавить менеджера"
        		+ "\n4) Добавить декана\n5) Добавить техническую поддержку\n6) Удалить пользователя\n7) Обновить пользователя\n8) Посмотреть "
        		+ "файлы журнала\n9) Выйти",
        		"Введите имя пользователя, пароль, имя, фамилию, пол (МУЖСКОЙ, ЖЕНСКИЙ), факультет, специальность студента построчно",
        		"Введите имя пользователя, пароль, имя, фамилию, пол (МУЖСКОЙ, ЖЕНСКИЙ), факультет, зарплату и должность преподавателя",
        		"Введите имя пользователя, пароль, имя, фамилия, пол (МУЖСКОЙ, ЖЕНСКИЙ), факультет, зарплата менеджера",
        		"Введите имя пользователя, пароль, имя, фамилию, пол(МУЖСКОЙ, ЖЕНСКИЙ), факультет, зарплата декана",
        		"Введите имя пользователя, пароль, имя, фамилию, пол (МУЖЧИНА, ЖЕНЩИНА), зарплата технического сотрудника",
        		"Введите идентификатор пользователя, который вы хотите удалить","Введите идентификатор, новый пароль и новое имя пользователя, которое "
        		+ "вы хотите обновить","1) Просмотреть жалобы\n2) Выйти",
        		"1) Просмотреть заказы\n2) Принять заказ\n3) Отклонить заказ\n4) Выйти", "Введите идентификатор заказа, который вы хотите принять",
        		"Введите идентификатор заказа, который вы хотите отклонить", "21) Отправить сообщение\n22) Просмотреть сообщение\n23) Просмотреть отправленное сообщение\n24) Отправить заказ",
        		"Введите имя, фамилия, роль получателя и ваше сообщение построчно", "Введите описание заказа",
        		"21) Отправить сообщение\n22) Просмотреть сообщение\n23) Просмотреть отправленное сообщение","Введите название курса, тип урока (ЛЕКЦИЯ, ПРАКТИКА, ЛАБОРАТОРНАЯ работа), формат (ОНЛАЙН, ОФФЛАЙН), дату (дд.ММ.гггг), день (ПОНЕДЕЛЬНИК....),"
        		+ "и код урока", "Введите название журнала:", "Новый журнал успешно создан!",
        		"Журнал успешно удален!", "Вы подписались на Журнал!", "Вы отписались от журнала!",
        		"Вы не подписаны на этот журнал!", "Журнал не найден.", "35) Станьте исследователем \n36) Выйдите из исследования \n37) Покажите h-индекс \n38) Покажите свои исследовательские работы \n39) Добавить исследовательскую работу \n40) Добавить цитаты в исследовательскую работу\n"
        		+ "43) Добавить исследовательскую работу в журнал.",
        		"Вы стали исследователем!", "Теперь вы не исследователь.", "Ошибка! Вы не исследователь!", "Выберите вариант сортировки: \n1)Без сортировки \n2)Сортировка по цитатам \n3)Сортировка по дате \n4)Сортировка по страницам",
        		"Введите название исследовательской работы, страницы, дату (дд.ММ.гггг)", "Исследовательская работа успешно добавлена!", "Введите название исследовательской работы", "Добавлена цитата",
        		"Исследовательская работа с указанным названием не найдена.", "Введите содержание цитата, сколько раз она использовалась", "Вы стали супервизором!", "Теперь вы не супервизор.", "41) Стать супервизором \n42) Не супервизор",
        		"Индекс Хирша меньше 3.", "31) Создать журнал\n32) Удалить Журнал" ,"30) Просмотр новостей", "Введите название организации, которую вы хотите создать",
        		"Введите название журнала, название научной статьи", "Исследовательская статья добавлена в журнал!", "Неправильное название журнала!","1) Новая цитата\n2) Используйте чью-то цитату", "Введите содержание цитаты", "Введите идентификатор чьей-то цитаты, которую вы хотели для использования:",
        };
}



