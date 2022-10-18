import React from 'react'
import styles from '../styles/NavBar.module.css'
function NavBar() {
    return (
        <nav className={styles.navbar}>
            <ul className={styles.ul}>
                <li className={styles.li_icon}>
                    <img src="icon.png" alt="icon" className={styles.icon} />
                </li>
                <li className={styles.li_search}>
                    <input type="text" className={styles.li_search_input} />
                    <button className={styles.li_search_button}>

                        <img src="search.svg" alt="search" className={styles.li_search_img} />
                    </button>
                </li>
                <li className={styles.li_profile}>
                    <span className={styles.li_user_name}>Julian Ippolito</span>
                    <img src="profile.svg" alt="perfil" className={styles.li_user_img} />
                </li>
            </ul>
        </nav>
    )
}

export default NavBar