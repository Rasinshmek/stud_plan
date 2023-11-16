package com.example.ymo.service;

import com.example.ymo.DTO.AnketDTO;
import com.example.ymo.DTO.Nagruzka;
import com.example.ymo.YmoApplication;
import com.example.ymo.entity.*;
import com.example.ymo.load.LoadFromFile;
import com.example.ymo.load.OtherServices;
import com.example.ymo.repository.*;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class NagruzkaService {
    @Autowired
    PlanRepo planRepo;
    @Autowired
    SemestrRepo semestrRepo;
    @Autowired
    SpecialityRepo specialityRepo;
    @Autowired
    NodeRepo nodeRepo;
    @Autowired
    PracticeRepo practiceRepo;

    @Autowired
    OtherServices otherServices;


    public List<Nagruzka> getNagruzka() throws Exception {
        System.out.println("1");
        List<Nagruzka> nagr = new ArrayList<Nagruzka>();
        System.out.println("111");
        LoadFromFile f = new LoadFromFile();
        System.out.println("222");
        List<AnketDTO> ankets = otherServices.getAnketDTOs();
        long i = 1;
        System.out.println("2");
        for (AnketDTO ank : ankets) {
            try {
                Speciality speciality = specialityRepo.findByShifr(ank.getSpeciality()).get(0);
                Plan plan = planRepo.findByEnrollmentYearAfterAndIdSpeciality(LocalDate.of(ank.getYear(), 1, 1), speciality).get(0);
                List<Node> nodes = nodeRepo.findByIdPlan(plan);
                for (int sem = 0; sem < 2; sem++) {
                    int curentSem = (ank.getCourse() * 2) - 1 + sem;
                    System.out.println("3");
                    for (Node node : nodes) {
                        List<Semestr> semestrs = semestrRepo.findByIdNodeAndNumber(node, curentSem);
                        if (semestrs.size() > 0) {
                            Semestr semestr = semestrs.get(0);
                            Nagruzka n = new Nagruzka();
                            System.out.println("4");
                            n.numberPlan = plan.getId();
                            n.idNagruzka = semestr.getNumber();
                            n.idPrep = "Prepod";
                            n.numberSemestr = curentSem;
                            n.studyForm = plan.getEducationForm();
                            n.idGroup = ank.getGroup();
                            n.numberFlow = ank.getNumberFLow();
                            n.idSubject = node.getIdSubject().getName();
                            n.idSpeciality = ank.getSpeciality();
                            n.course = ank.getCourse();
                            n.countStudenty = ank.getStudentCount();
                            n.countPodgroup = ank.getCountSubGroup();
                            n.lecture = semestr.getLecture();
                            n.practice = semestr.getPractice();
                            n.laboratory = round(semestr.getLaboratory() * n.countPodgroup);
                            n.consultation = round(Objects.equals(plan.getEducationForm(), "очная") ?
                                    ((f.coefConsDnev1 * n.lecture) + (n.countStudenty * f.coefConsDnev2) + 2) :
                                    Objects.equals(plan.getEducationForm(), "заочная") ?
                                            (n.countStudenty * f.coefConsZaoch + 2) : 0);
                            String type = semestr.getType();
                            if (Objects.equals(type, "экзамен"))
                                n.ekzam = round(n.countStudenty * f.coefEkzam);
                            if (Objects.equals(type, "просмотр"))
                                n.view = round(n.countStudenty * f.coefView);
                            if (Objects.equals(type, "дифзачёт"))
                                n.difZach = round(n.countStudenty * f.coefDifZach);
                            if (Objects.equals(type, "зачёт")) ;
                                n.zach = round(n.countStudenty * f.coefZach);
                            n.rgr = round(n.countStudenty * f.coefRGR * semestr.getRgr());

                            List<Practice> practices = practiceRepo.findByIdPlanAndIdSemestr(plan, curentSem);
                            if (practices.size() > 0) {
                                Practice pracice = practices.get(0);
                                if (Objects.equals(pracice.getType(), "учебная")) {
                                    n.rukPractice = f.coefPracticeUchebHour * f.coefPracticeUchebDay * pracice.getCountWeek() * 1;//?
                                }
                                if (Objects.equals(pracice.getType(), "производственная")) {
                                    if (Objects.equals(plan.getEducationForm(), "очная")) {
                                        n.rukPractice = pracice.getCountWeek() * ank.getStudentCount() * f.coefPracticeProizvDnev;
                                    }
                                    if (Objects.equals(plan.getEducationForm(), "заочная")) {
                                        n.rukPractice = pracice.getCountWeek() * ank.getStudentCount() * f.coefPracticeProizvZaoch1 * f.coefPracticeProizvZaoch2;
                                    }
                                }


                            }
                            n.coursRab = f.coefCursRab * ank.getStudentCount();
                            n.coursProj = f.coefCursProject * ank.getStudentCount();
                            //n.contrRab= f.coefContrRab*ank.getStudentCount()*1;//?

                            if (Objects.equals(plan.getDiplomName(), "проект")) {
                                n.diplomProekt = f.coefDiplomProekt * ank.getStudentCount();
                            }
                            if (Objects.equals(plan.getDiplomName(), "работа")) {

                                n.diplomProekt = f.coefDiplomRabota * ank.getStudentCount();
                            }

                            n.gek = f.coefGEKZashDipl * ank.getStudentCount();

                            nagr.add(n);
//                            n.diplomProekt = f.coefDiplomRecenz*2 ;
//                            nagr.add(n);
//                            if (plan.getGovExam()!=0) {
//
//                                n.gek= f.coefGEKSpec*ank.getStudentCount();
//                                nagr.add(n);
//                            }


                        }

                    }
                }
                i++;


            } catch (Exception e) {
                System.out.println(e.getMessage() + ": " + ank.getSpeciality());
                if (ank.getSpeciality().equals("1-40 05 01")) System.out.println("Problem");
            }
        }

        System.out.println("7");
        return nagr;
    }

    private double round(double hours) {
        return (double) Math.round(hours * 100) / 100;
    }
}
