import Team from './Team';
function AboutUs() {
    return (
        <section className="container mt-5">
            <div className="row">
                <img className="img" alt="pic1" src={'/assets/about.jpg'} />
                <h2>About Us</h2>
                <div>
                    <p>
                    Welcome to PathoLab at Your Doorstep, your trusted partner in convenient and reliable diagnostic services. Our mission is to provide you with top-notch medical testing solutions without the hassle of leaving your home. We understand that your health is of paramount importance, and we're here to make sure you have access to accurate and timely diagnostic information. Our dedicated team of skilled medical professionals and technicians brings together the best in technology and care to deliver a seamless experience. From routine blood tests to specialized screenings, we offer a comprehensive range of services aimed at catering to your unique health needs. Our commitment to convenience, accuracy, and privacy sets us apart. Experience the future of healthcare with PathoLab at Your Doorstep, where your well-being is our priority.
                    </p>
                    <Team/>

                    <div className="container mt-5"
                        style={{ backgroundColor: "rgb(149, 197, 231)" }}>
                        <h2>Get In Touch</h2>
                        <hr />
                        <div className="row">
                            <div className="col-md-4">
                                <h4>Tanmayi Joshi</h4>
                                <ul>
                                    <li>7350661280</li>
                                    <li>
                                        Raintree Marg, near Bharti vidyapeeth, sector 7,Aundh,
                                       Pune, Maharashtra 400614
                                    </li>
                                </ul>
                            </div>
                            <div className="col-md-4">
                                <h4>Kshitija Bhuvad</h4>
                                <ul>
                                    <li>9421636358</li>
                                    <li>
                                        Raintree Marg, near Bharti Vidyapeeth, sector 7,Aundh,
                                        Pune, Maharashtra 400614
                                    </li>
                                </ul>
                            </div>
                            <div className="col-md-4">
                                <h4>Komal Mete</h4>
                                <ul>
                                    <li>7709045371</li>
                                    <li>
                                        Raintree Marg, near Bharti vidyapeeth, sector 7, Aundh,
                                        Pune, Maharashtra 400614
                                    </li>
                                </ul>
                            </div>
                            <div className="col-md-4">
                                <h4>Kartika Harnol</h4>
                                <ul>
                                    <li>9909104532</li>
                                    <li>
                                        Raintree Marg, near Bharti vidyapeeth, sector 7, Aundh,
                                        Pune, Maharashtra 400614
                                    </li>
                                </ul>
                            </div>
                            <div className="col-md-4">
                                <h4>Himanshu Kamane</h4>
                                <ul>
                                    <li>987045371</li>
                                    <li>
                                        Raintree Marg, near Bharti vidyapeeth, sector 7,Aundh,
                                        Pune, Maharashtra 400614
                                    </li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
    );
}

export default AboutUs;