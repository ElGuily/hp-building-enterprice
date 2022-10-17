import Head from 'next/head'
import Image from 'next/image'
import styles from '../styles/Home.module.css'

import NavBar from '../components/NavBar'

export default function Home() {
  return (
    <div>
      <Head>
        <title>HP Building Enterprice</title>
        <link rel="shortcut icon" href="favicon.png" type="image/x-icon" />
      </Head>

      <NavBar></NavBar>
    </div>
  )
}
