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
                            n.ekzam = round(n.countStudenty * f.coefEkzam);
                            n.view = round(n.countStudenty * f.coefView);
                            n.difZach = round(n.countStudenty * f.coefDifZach);
                            n.zach = round(n.countStudenty * f.coefZach);
                            n.rgr = round(n.countStudenty * f.coefRGR * semestr.getRgr());

                            List<Practice> practices = practiceRepo.findByIdPlanAndIdSemestr(plan, curentSem);
//                        if(practices.size()>0)
//                        {
//                            Practice pracice= practices.get(0);
//
//                            n.practice= Objects.equals(pracice.getType(), "учебная") ? f.coefPracticeUchebHour*f.coefPracticeUchebDay*pracice.getCountWeek()*n.
//                        }
                            System.out.println("5");
                            nagr.add(n);
                            System.out.println("6");


                        }

                    }
                }
                i++;
                System.out.println("7");


            } catch (Exception e) {
                System.out.println(e.getMessage() + ": " + ank.getSpeciality());
                if(ank.getSpeciality().equals("1-40 05 01")) System.out.println("Problem");
            }
        }

        System.out.println("7");
        return nagr;
    }

    private double round(double hours) {
        return (double) Math.round(hours * 100) / 100;
    }
}
