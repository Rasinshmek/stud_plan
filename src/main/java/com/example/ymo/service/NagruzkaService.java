package com.example.ymo.service;

import com.example.ymo.DTO.AnketDTO;
import com.example.ymo.DTO.Nagruzka;
import com.example.ymo.YmoApplication;
import com.example.ymo.entity.*;
import com.example.ymo.load.LoadFromFile;
import com.example.ymo.load.OtherServices;
import com.example.ymo.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

    OtherServices otherServices;


    public List<Nagruzka> getNagruzka() throws Exception {

        List<Nagruzka> nagr = new ArrayList<Nagruzka>();
        LoadFromFile f = new LoadFromFile();
        List<AnketDTO> ankets = otherServices.getAnketDTOs();
        long i = 1;
        for (AnketDTO ank : ankets) {

            Speciality speciality = specialityRepo.findByShifr(ank.getSpeciality()).get(0);
            Plan plan = planRepo.findByEnrollmentYearAfterAndIdSpeciality(new Date(ank.getYear(), 1, 1), speciality).get(0);
            List<Node> nodes = nodeRepo.findByIdPlan(plan);
            for (int sem = 0; sem < 2; sem++) {
                int curentSem = (ank.getCourse() * 2) - 1 + sem;

                for (Node node : nodes) {
                    List<Semestr> semestrs = semestrRepo.findByIdNodeAndNumber(node, curentSem);
                    if (semestrs.size() > 0) {
                        Semestr semestr = semestrs.get(0);
                        Nagruzka n = new Nagruzka();

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
                        n.countPodgroup = Integer.parseInt(Math.ceil(ank.getStudentCount() / 2) + "");
                        n.lecture = semestr.getLecture();
                        n.practice = semestr.getPractice();
                        n.laboratory = semestr.getLaboratory() * n.countPodgroup;
                        n.consultation = Objects.equals(plan.getEducationForm(), "очная") ?
                                ((f.coefConsDnev1 * n.lecture) + (n.countStudenty * f.coefConsDnev2) + 2) :
                                Objects.equals(plan.getEducationForm(), "заочная") ?
                                        (n.countStudenty * f.coefConsZaoch + 2) :0;
                        n.ekzam= n.countStudenty*f.coefEkzam;
                        n.view= n.countStudenty*f.coefView;
                        n.difZach= n.countStudenty*f.coefDifZach;
                        n.zach= n.countStudenty*f.coefZach;
                        n.rgr= n.countStudenty*f.coefRGR*semestr.getRgr();

                        List<Practice> practices = practiceRepo.findByIdPlanAndIdSemestr(plan,curentSem);
//                        if(practices.size()>0)
//                        {
//                            Practice pracice= practices.get(0);
//
//                            n.practice= Objects.equals(pracice.getType(), "учебная") ? f.coefPracticeUchebHour*f.coefPracticeUchebDay*pracice.getCountWeek()*n.
//                        }
                        nagr.add(n);




                    }

                }
            }
            i++;


        }


        return nagr;
    }


}
