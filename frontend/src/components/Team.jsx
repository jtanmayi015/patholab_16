import React from 'react';

const Team = () => {
  const teamMembers = [
    {
      name: 'Tanmayi Joshi',
      designation: 'Hematopathologist',
      imageSrc: './assets/tanu.jpg',
      facebookLink: '',
      twitterLink: '',
      instagramLink: '',
    },
    {
      name: 'Kshitija Bhuvad',
      designation: 'Neuropathologist',
      imageSrc: './assets/kshitu.jpg',
      facebookLink: '',
      twitterLink: '',
      instagramLink: '',
    },
    {
      name: 'Komal Mete',
      designation: 'Dermatopathologist',
      imageSrc: './assets/komal1.jpg',
      facebookLink: '',
      twitterLink: '',
      instagramLink: '',
    },
    {
      name: 'Kartika Harnol',
      designation: 'Chemical pathologist',
      imageSrc: './assets/kart.jpg',
      facebookLink: '',
      twitterLink: '',
      instagramLink: '',
    },
  ];

  return (
    <div className="container-xxl py-5">
      <div className="container">
        <div className="text-center wow fadeInUp" data-wow-delay="0.1s">
          <h1 className="mb-5">Our Team</h1>
        </div>
        <div className="row g-4">
          {teamMembers.map((member, index) => (
            <div key={index} className="col-lg-3 col-md-6 wow fadeInUp" data-wow-delay={`0.${index + 1}s`}>
              <div className="team-item bg-light">
                <div className="overflow-hidden">
                  <img className="img-fluid" src={member.imageSrc} alt={member.name} />
                </div>
                <div className="position-relative d-flex justify-content-center" style={{ marginTop: '-23px' }}>
                  <div className="bg-light d-flex justify-content-center pt-2 px-1">
                    <a className="btn btn-sm-square btn-primary mx-1" href={member.facebookLink}>
                      <i className="fab fa-facebook-f"></i>
                    </a>
                    <a className="btn btn-sm-square btn-primary mx-1" href={member.twitterLink}>
                      <i className="fab fa-twitter"></i>
                    </a>
                    <a className="btn btn-sm-square btn-primary mx-1" href={member.instagramLink}>
                      <i className="fab fa-instagram"></i>
                    </a>
                  </div>
                </div>
                <div className="text-center p-4">
                  <h5 className="mb-0">{member.name}</h5>
                  <small>{member.designation}</small>
                </div>
              </div>
            </div>
          ))}
        </div>
      </div>
    </div>
  );
};

export default Team;
