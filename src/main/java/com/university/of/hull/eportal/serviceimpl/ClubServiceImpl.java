package com.university.of.hull.eportal.serviceimpl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.university.of.hull.eportal.extradata.PaymentStatus;
import com.university.of.hull.eportal.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.university.of.hull.eportal.dataentity.Clubs;
import com.university.of.hull.eportal.dataentity.Events;
import com.university.of.hull.eportal.dataentity.Subscription;
import com.university.of.hull.eportal.datamodel.events.CreateEventRequest;
import com.university.of.hull.eportal.datamodel.events.CreateEventResponse;
import com.university.of.hull.eportal.datamodel.events.FetchEventResponse;
import com.university.of.hull.eportal.datamodel.events.JoinEventRequest;
import com.university.of.hull.eportal.datamodel.events.JoinEventResonse;
import com.university.of.hull.eportal.datamodel.signup.ClubSignUpRequest;
import com.university.of.hull.eportal.datamodel.signup.FetchClubsResponse;
import com.university.of.hull.eportal.datamodel.signup.SignUpResponse;
import com.university.of.hull.eportal.extradata.Roles;
import com.university.of.hull.eportal.extradata.Status;
import com.university.of.hull.eportal.repository.ClubRepository;
import com.university.of.hull.eportal.repository.EventRepository;
import com.university.of.hull.eportal.repository.SubscriptionRepository;
import com.university.of.hull.eportal.service.ClubService;

@Service
public class ClubServiceImpl implements ClubService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ClubRepository clubRepository;

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private SubscriptionRepository subscriptionRepository;

	@Autowired
	private GeneralService generalService;

	@Override
	public SignUpResponse clubSignUp(ClubSignUpRequest clubSignUpRequest) {
		SignUpResponse signUpResponse = new SignUpResponse();

		Clubs clubsSignUp = new Clubs();
		clubsSignUp.setClubName(clubSignUpRequest.getClubName());
		clubsSignUp.setClubAddress(clubSignUpRequest.getClubAddress());
		clubsSignUp.setClubContactNumber(clubSignUpRequest.getClubContactNumber());
		clubsSignUp.setClubEmail(clubSignUpRequest.getClubEmail());
		clubsSignUp.setClubId(clubSignUpRequest.getClubId());
		clubsSignUp.setPassword(passwordEncoder.encode(clubSignUpRequest.getPassword()));
		clubsSignUp.setCountry(clubSignUpRequest.getCountry());
		clubsSignUp.setClubStatus(Status.Pending);
		clubsSignUp.setUserRole(Roles.Club);
		if (clubRepository.findByClubId(clubSignUpRequest.getClubId()) == null) {
			Clubs clubs = clubRepository.save(clubsSignUp);
			if (null != clubs) {
				generalService.sendMailMessage(clubSignUpRequest.getClubEmail(),"Thanks for joining","Welcome to eClub, you have successfully registered your club ");
				signUpResponse.setMessage("Club Signed Up Succesfully");
			}
		} else {
			signUpResponse.setMessage("Club Exists! Please supply new club details");
			throw new RuntimeException("Club Exists! Please supply new club details");
		}
		return signUpResponse;
	}

	@Override
	public CreateEventResponse createEvent(CreateEventRequest createEventRequest) {
		CreateEventResponse createEventResponse = new CreateEventResponse();

		Events clubEvents = new Events();
		clubEvents.setTitle(createEventRequest.getTitle());
		clubEvents.setDescription(createEventRequest.getDescription());
		clubEvents.setLocation(createEventRequest.getLocation());
		clubEvents.setCost(createEventRequest.getCost());
		clubEvents.setAvailableSeats(createEventRequest.getAvailableSeats());
		clubEvents.setStartDateAndTime(createEventRequest.getStartDateAndTime());
		clubEvents.setEndDateAndTime(createEventRequest.getEndDateAndTime());
		clubEvents.setImgVidPath(createEventRequest.getImgVidPath());
		Clubs club = clubRepository.findByClubId(createEventRequest.getClubId());
		if (club != null) {
			clubEvents.setClub(club);
		} else {
			createEventResponse.setMessage("Club does not exists, Please supply proper club details");
			throw new RuntimeException("Club does not exists, Please supply proper club details");
		}

		Events events = eventRepository.save(clubEvents);
		if (null != events) {
			createEventResponse.setMessage("Event created succesfully");
		}
		return createEventResponse;
	}

	@Override
	public FetchEventResponse fetchEventByEventId(Long eventId) {
		FetchEventResponse fetchEventResponse = new FetchEventResponse();
		Events events = eventRepository.findByEventId(eventId);
		if (events != null) {
			CreateEventRequest event = new CreateEventRequest();
			event.setTitle(events.getTitle());
			event.setDescription(events.getDescription());
			event.setClubId(events.getClub().getClubId());
			event.setAvailableSeats(events.getAvailableSeats());
			event.setCost(events.getCost());
			event.setLocation(events.getLocation());
			event.setStartDateAndTime(events.getStartDateAndTime());
			event.setEndDateAndTime(events.getEndDateAndTime());
			event.setImgVidPath(events.getImgVidPath());
			fetchEventResponse.setEvent(event);
			fetchEventResponse.setMessage("Event fetched succesfully");
		} else {
			fetchEventResponse.setMessage("Event does not exists, Please supply proper event id");
			throw new RuntimeException("Event does not exists, Please supply proper event id");
		}
		return fetchEventResponse;
	}

	@Override
	public FetchEventResponse fetchEventByClubId(String clubId) {
		FetchEventResponse fetchEventResponse = new FetchEventResponse();
		Clubs club = clubRepository.findByClubId(clubId);
		if(club != null) {
			List<Events> events = eventRepository.findByClubId(clubId);
			if(!events.isEmpty()) {
				List<CreateEventRequest> createEventRequests = new ArrayList<CreateEventRequest>();
				for(Events event : events)
				{
					CreateEventRequest eventResp = new CreateEventRequest();
					eventResp.setTitle(event.getTitle());
					eventResp.setDescription(event.getDescription());
					eventResp.setClubId(event.getClub().getClubId());
					eventResp.setAvailableSeats(event.getAvailableSeats());
					eventResp.setCost(event.getCost());
					eventResp.setLocation(event.getLocation());
					eventResp.setStartDateAndTime(event.getStartDateAndTime());
					eventResp.setEndDateAndTime(event.getEndDateAndTime());
					eventResp.setImgVidPath(event.getImgVidPath());
					createEventRequests.add(eventResp);	
				}
				fetchEventResponse.setEventList(createEventRequests);
				fetchEventResponse.setMessage("Events fetched succesfully");
			} else {
				fetchEventResponse.setMessage("Event does not exists, Please supply proper club id");
				throw new RuntimeException("Event does not exists, Please supply proper club id");
			}
		} else {
			fetchEventResponse.setMessage("Club does not exists, Please supply proper club id");
			throw new RuntimeException("Club does not exists, Please supply proper club id");
		}
		return fetchEventResponse;
	}

	@Override
	public FetchClubsResponse fetchClubs() {
		FetchClubsResponse fetchClubsResponse = new FetchClubsResponse();
		List<Clubs> clubs = clubRepository.findByClubStatusIs(Status.Active);
		if(clubs != null) {
				List<ClubSignUpRequest> fetchedClubs = new ArrayList<ClubSignUpRequest>();
				for(Clubs club : clubs)
				{
					ClubSignUpRequest clubResp = new ClubSignUpRequest();
					clubResp.setClubName(club.getClubName());
					clubResp.setClubEmail(club.getClubEmail());
					clubResp.setClubId(club.getClubId());
					clubResp.setClubAddress(club.getClubAddress());
					clubResp.setCountry(club.getCountry());
					clubResp.setClubContactNumber(club.getClubContactNumber());
					clubResp.setClubStatus(club.getClubStatus());
					fetchedClubs.add(clubResp);	
				}
				fetchClubsResponse.setRegisterdClubs(fetchedClubs);
				fetchClubsResponse.setMessage("Clubs fetched succesfully");
		} else {
			fetchClubsResponse.setMessage("Club does not exists, Please try again later");
			throw new RuntimeException("Club does not exists, Please try again later");
		}
		return fetchClubsResponse;
	}

	@Override
	public JoinEventResonse joinEvent(JoinEventRequest joinEventRequest) {
		JoinEventResonse joinEventResonse = new JoinEventResonse();
		Clubs club = clubRepository.findByClubId(joinEventRequest.getClubId());
		if(club != null) {
			Events events = eventRepository.findByEventId(joinEventRequest.getEventId());
			if (events != null) {
				Subscription subscriptions = subscriptionRepository.findByUserId(joinEventRequest.getUserId());
				if (subscriptions == null) {
					Subscription subscription = new Subscription();
					subscription.setClubId(joinEventRequest.getClubId());
					subscription.setEventId(joinEventRequest.getEventId());
					subscription.setUserId(joinEventRequest.getUserId());
					subscription.setPaymentStatus(PaymentStatus.Paid);
					subscription.setSubDate(new Timestamp(System.currentTimeMillis()));
					Subscription sub = subscriptionRepository.save(subscription);
					if (null != sub) {
						joinEventResonse.setMessage("Successfully subscribed the event.");
					} else {
						joinEventResonse.setMessage("Failed to subscribe the event! Please try again later.");
						throw new RuntimeException("Failed to subscribe the event! Please try again later.");
					}
				} else {
					joinEventResonse.setMessage("User already subscribed to the event!");
					throw new RuntimeException("User already subscribed to the event!");
				}
				
			} else {
				joinEventResonse.setMessage("Event does not exists! Please supply valid Event Id");
				throw new RuntimeException("Event does not exists! Please supply valid Event Id");
			}
			
		} else {
			joinEventResonse.setMessage("Club does not exists! Please supply valid Club Id");
			throw new RuntimeException("Club does not exists! Please supply valid Club Id");
		}
		return joinEventResonse;
	}

}
