import Head from "next/head";
import Image from "next/image";
import styles from "../styles/Home.module.css";

import NavBar from "../components/NavBar";

export default function Home() {
  return (
    <div>
      <Head>
        <title>HP Building Enterprise</title>
        <link rel="shortcut icon" href="favicon.png" type="image/x-icon" />
      </Head>
      <NavBar></NavBar>
    <main>

      <div className={styles.landing}>
        <div className={styles.main_div}>
          <h1 className={styles.main_div_h1}>Hewlett-Packard</h1>
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

      </div>
    </main>
    </div>
  );
}
