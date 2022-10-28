import Head from "next/head";
import styles from "../styles/Home.module.css";
import Link from "next/link";

import NavBar from "../components/NavBar";

import PcCardType from "../components/PcCardType";

export default function Home() {
  return (
    <div className={styles.mainbox}>
      <Head>
        <title>HP Building Enterprise</title>
        <link rel="shortcut icon" href="favicon.png" type="image/x-icon" />
      </Head>
      <NavBar></NavBar>
    <main>

      <div className={styles.landing}>
        <div className={styles.main_div}>
          <h1 className={styles.main_div_h1}>Hewlett-Packets</h1>
          <h2 className={styles.main_div_h2}>Building Enterprise</h2>
        </div>
        <img src="computers.svg" alt="mainimg" className={styles.main_img} />
        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1440 320" className={styles.main_wave}>
          <path
            fill="#0099ff"
            fill-opacity="1"
            d="M0,32L48,58.7C96,85,192,139,288,176C384,213,480,235,576,240C672,245,768,235,864,202.7C960,171,1056,117,1152,101.3C1248,85,1344,107,1392,117.3L1440,128L1440,320L1392,320C1344,320,1248,320,1152,320C1056,320,960,320,864,320C768,320,672,320,576,320C480,320,384,320,288,320C192,320,96,320,48,320L0,320Z"
          ></path>
        </svg>
      </div>
      <div className={styles.postLanding}>
        <h3 className={styles.postLanding__h3}>Busca el computador de tus sueños</h3>
        <div className={styles.postLanding__cajas}>
          <PcCardType img="/oficina.png" type="Oficina" link="/Pcs?q=Oficina"></PcCardType>
          <PcCardType img="/gamer.png" type="Gamer" link="/Pcs?q=Gamer"></PcCardType>
          <PcCardType img="/diseño.png" type="Diseño" link="/Pcs?q=Diseño"></PcCardType>

        </div>
      </div>
    </main>
    </div>
  );
}
